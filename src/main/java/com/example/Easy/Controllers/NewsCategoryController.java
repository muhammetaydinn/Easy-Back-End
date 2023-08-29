package com.example.Easy.Controllers;

import com.example.Easy.Models.NewsCategoryDTO;
import com.example.Easy.Services.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/categories")
public class NewsCategoryController {

    @Autowired
    NewsCategoryService newsCategoryService;
    @GetMapping("/hierarchy")
    public Map<String, Map> getCategories(){
        return newsCategoryService.mapjson();
    }

    @GetMapping
    public List<NewsCategoryDTO> getAllCategories(){
        return newsCategoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public NewsCategoryDTO getCategoryById(@PathVariable("categoryId") Long categoryId){
        return  newsCategoryService.getNewsCategoryById(categoryId);
    }


}
