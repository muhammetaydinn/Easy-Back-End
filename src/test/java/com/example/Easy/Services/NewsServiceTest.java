package com.example.Easy.Services;

import com.example.Easy.Entities.NewsEntity;
import com.example.Easy.Mappers.NewsMapper;
import com.example.Easy.Models.NewsCategories;
import com.example.Easy.Models.NewsDTO;
import com.example.Easy.Repository.NewsRepository;
import org.checkerframework.checker.units.qual.N;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NewsServiceTest {

    @Autowired
    NewsService newsService;
    @Test
    void postTest(){

        NewsDTO new1 = NewsDTO.builder()
                .title("test6")
                .image("https://www.google.com/search?q=machine+learning&sca_esv=559361602&tbm=isch&source=lnms&sa=X&ved=2ahUKEwiC5--r-PKAAxVSYPEDHVsTCq4Q_AUoAnoECAIQBA&biw=1728&bih=931&dpr=2#imgrc=MljwM1234Xl_pM")
                .text("bootstrap3")
                .newsCategories(NewsCategories.MACHINE_LEARNING)
                .build();
        newsService.postNews(new1);
    }
    @Test
    void getByTopicTest(){
        List<NewsDTO> list = newsService.getNewsByTitle("test2");
        System.out.println(list);
    }
    @Test
    void getByCategoryTest(){
        List<NewsDTO> list = newsService.getNewsByCategory(NewsCategories.MACHINE_LEARNING);
        System.out.println(list);
    }
    @Test
    void deleteById(){
        newsService.deletePostById(UUID.fromString("4c0da237-72f1-4b72-9e36-91dc815faba3"));
    }


}