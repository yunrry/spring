package com.example.restapi_ex.service;

import com.example.restapi_ex.controller.entity.ItemEntity;
import com.example.restapi_ex.controller.entity.ItemRepository;
import com.example.restapi_ex.controller.model.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class RestExService {

    private final ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto){
        //dto -> entity
        ItemEntity entity = new ItemEntity();
        entity.setId(itemDto.getId());
        entity.setName(itemDto.getName());

        //DB insert
        var reEntity = itemRepository.save(entity);

        log.info("save item entity: " + reEntity);

        return true; // DB insert 성공했을 경우 true
    }
}
