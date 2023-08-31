package com.example.Easy.Models;

import com.example.Easy.Entities.NewsCategoryEntity;
import com.example.Easy.Entities.NewsEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;
@Data
@Builder
public class NewsCategoryDTO {
    private Long categoryId;
    private String name;
}
