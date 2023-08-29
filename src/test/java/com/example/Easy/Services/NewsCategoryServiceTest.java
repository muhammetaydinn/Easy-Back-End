package com.example.Easy.Services;

import com.example.Easy.Entities.NewsCategoryEntity;
import com.example.Easy.Mappers.NewsCategoryMapper;
import com.example.Easy.Models.NewsCategoryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NewsCategoryServiceTest {
    @Autowired
    NewsCategoryService newsCategoryService;

    @Autowired
    NewsCategoryMapper newsCategoryMapper;


    @Test
    void bootstrap(){
        addCategoryTest();
        addSubCategory();
        subsub();
    }

    @Test
    void addCategoryTest(){
        NewsCategoryDTO cat1 = NewsCategoryDTO.builder()
                .name("cat1")
                .parent(null)
                .build();
        NewsCategoryDTO cat2 = NewsCategoryDTO.builder()
                .name("cat2")
                .parent(null)
                .build();
        NewsCategoryDTO cat3 = NewsCategoryDTO.builder()
                .name("cat3")
                .parent(null)
                .build();

        newsCategoryService.addNewCategory(cat1);
        newsCategoryService.addNewCategory(cat2);
    }
    @Test
    void addSubCategory(){
        NewsCategoryDTO cat1 = newsCategoryService.getNewsCategoryById(1L);
        NewsCategoryDTO cat2 = newsCategoryService.getNewsCategoryById(2L);

        NewsCategoryDTO sub1 = NewsCategoryDTO.builder()
                .name("sub1")
                .children(new HashSet<>())
                .parent(newsCategoryMapper.toNewsCategoryEntity(cat1))
                .build();
        NewsCategoryDTO sub2 = NewsCategoryDTO.builder()
                .name("sub2")
                .parent(newsCategoryMapper.toNewsCategoryEntity(cat1))
                .build();


        cat1.getChildren().add(newsCategoryMapper.toNewsCategoryEntity(sub1));
        cat2.getChildren().add(newsCategoryMapper.toNewsCategoryEntity(sub2));
        newsCategoryService.addNewCategory(cat1);
        newsCategoryService.addNewCategory(cat2);
        newsCategoryService.addNewCategory(sub1);
        newsCategoryService.addNewCategory(sub2);


    }
    @Test
    void subsub(){
        NewsCategoryDTO sub1 = newsCategoryService.getNewsCategoryById(3L);
        NewsCategoryDTO subSub1 = NewsCategoryDTO.builder()
                .name("subsub1")
                .parent(newsCategoryMapper.toNewsCategoryEntity(sub1))
                .build();

        sub1.getChildren().add(newsCategoryMapper.toNewsCategoryEntity(subSub1));
        newsCategoryService.addNewCategory(subSub1);
    }

    @Test
    void getAllCategories(){
        List<NewsCategoryDTO> newsCategoryDTOS = newsCategoryService.getAllCategories();
        System.out.println(newsCategoryDTOS);
    }
    @Test
    void getAllRoots(){
        List<NewsCategoryDTO> newsCategoryDTOS = newsCategoryService.getAllRoots();
        System.out.println(newsCategoryDTOS);
        Map map = newsCategoryService.mapjson();
        System.out.println(map);
    }

    @Test
    void getCategoryById(){
        NewsCategoryDTO newsCategoryDTO = newsCategoryService.getNewsCategoryById(2L);
        System.out.println(newsCategoryDTO.getNews());

    }





}