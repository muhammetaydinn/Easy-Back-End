package com.example.Easy.Services;

import com.example.Easy.Mappers.NewsMapper;
import com.example.Easy.Mappers.UserMapper;
import com.example.Easy.Models.CommentDTO;
import com.example.Easy.Models.NewsDTO;
import com.example.Easy.Models.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService commentService;
    @Autowired
    NewsService newsService;
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Test
    void commentPostTest() {
        NewsDTO newsDTO = newsService.getAllNews().get(1);
        UserDTO userDTO = userService.listUsers().get(1);

        CommentDTO commentDTO = CommentDTO.builder()
                .text("hi")
                .news(newsMapper.toNewsEntity(newsDTO))
                .author(userMapper.toUserEntity(userDTO))
                .build();

        commentService.postComment(commentDTO);
    }
}