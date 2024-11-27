package com.example.catwiki.controller;

import com.example.catwiki.model.Cat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // @Controller + @ResponseBody
@RequestMapping("/cats")
public class CatController {

    private final List<Cat> catList = new ArrayList<Cat>();

    public CatController() {
        catList.add(new Cat(1L, "Milo", "수컷", 3));
        catList.add(new Cat(2L, "Luna", "암컷", 2));
        catList.add(new Cat(3L, "Leo", "암컷", 4));
    }

    // 고양이 리스트를 반환
    // http://localhost:8080/cats
    @GetMapping
    public List<Cat> getAllCats() {
        return catList;
    }

    // 고양이 정보 조회
    // http://localhost:8080/cats/1
    @GetMapping("/{id}")
    public Cat getCatById(
            @PathVariable Long id
    ) {
        /*for (Cat cat : catList) {
            if(cat.getId().equals(id)) {
                return cat;
            }
        }*/
        Optional<Cat> cat =  catList.stream().filter(c -> c.getId().equals(id)).findFirst(); // Optional로 받음(값이 없을 수도 있음)
        return cat.orElse(null);
    }

    // 새로운 고양이 추가
    // http://localhost:8080/cats
    @PostMapping
    public Cat addCat(
            @RequestBody Cat cat
    ){
        cat.setId(catList.size() + 1L);
        catList.add(cat);
        return cat;
    }

    // 고양이 삭제
    @DeleteMapping("/{id}")
    public String deleteCat(@PathVariable Long id) {
        for (Cat cat : catList) {
            if(cat.getId().equals(id)) {
                catList.remove(cat);
                return "(id: " + id + ") Cat removed";
            }
        }
        return "(id: " + id + ") Cat not found";
    }
}
