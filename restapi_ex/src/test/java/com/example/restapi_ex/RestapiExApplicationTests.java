package com.example.restapi_ex;

import com.example.restapi_ex.entity.UserEntity;
import com.example.restapi_ex.entity.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class RestapiExApplicationTests {

    @Mock
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUser() {
        UserEntity entity = UserEntity.builder()
                .name("test")
                .email("test@test.com")
                .build();

        when(userRepository.save(any(UserEntity.class))).thenReturn(entity);

        verify(userRepository, times(1)).save(any(UserEntity.class));
    }


}
