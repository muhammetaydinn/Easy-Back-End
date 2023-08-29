package com.example.Easy.Controllers;

import com.example.Easy.Entities.NewsEntity;
import com.example.Easy.Models.NewsCategoryDTO;
import com.example.Easy.Models.NewsDTO;
import com.example.Easy.Services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    NewsService newsService;

    @GetMapping
    public List<NewsDTO> getAllNews(){
        return newsService.getAllNews();
    }

    @GetMapping("/category/{categoryId}")
    public Set<NewsEntity> getNewsByCategory(@PathVariable("categoryId") Long categoryId){
        return newsService.getNewsByCategoryId(categoryId);
    }


    @GetMapping("/title/{title}")
    public List<NewsDTO> getNewsByTitle(@PathVariable("title") String title){
        return newsService.getNewsByTitle(title);
    }
    @PostMapping()
    public ResponseEntity postNews(@RequestBody NewsDTO newsDTO){
        newsService.postNews(newsDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("{newsUUID}")
    public ResponseEntity deletePostById(@PathVariable("newsUUID")UUID newsUUID){
        newsService.deletePostById(newsUUID);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }






}
