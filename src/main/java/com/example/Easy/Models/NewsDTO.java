package com.example.Easy.Models;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class NewsDTO {

    private UUID newsUUID;
    private String title;
    private String text;
    private String image;
    private NewsCategories newsCategories;

}
