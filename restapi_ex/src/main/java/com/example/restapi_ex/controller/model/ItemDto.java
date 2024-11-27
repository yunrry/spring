package com.example.restapi_ex.controller.model;

import lombok.*;
import org.springframework.stereotype.Service;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private String id;
    private String name;
}
