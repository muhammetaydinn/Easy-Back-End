package com.example.Easy.Models;

import com.example.Easy.Entities.CommentEntity;
import com.example.Easy.Entities.NewsCategoryEntity;
import com.example.Easy.Entities.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@Builder
public class NewsDTO {

    private UUID newsUUID;
    private String title;
    private String text;
    private String image;
    private UserEntity author;
    private LocalDateTime creationTime;
    private NewsCategoryEntity category;
    private List<CommentEntity> comments;

}
