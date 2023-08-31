package com.example.Easy.Models;

import com.example.Easy.Entities.NewsEntity;
import com.example.Easy.Entities.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class CommentDTO {
    private UUID commentId;
    private String text;
    private UserDTO author;
    private NewsDTO news;
}
