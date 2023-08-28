package com.example.Easy.Models;

import com.example.Easy.Entities.CommentEntity;
import com.example.Easy.Entities.NewsEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
@Builder
public class UserDTO {

    private UUID userId;
    private String name;
    private String image;
    private String userToken;
    private Integer role;
    private List<CommentEntity> comments;
    private List<NewsEntity> news;
}
