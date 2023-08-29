package com.example.Easy.Repository;

import com.example.Easy.Entities.NewsCategoryEntity;
import com.example.Easy.Entities.NewsEntity;
import com.example.Easy.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface NewsRepository extends JpaRepository<NewsEntity, UUID> {
    List<NewsEntity> findByTitle(String title);

    List<NewsEntity> findByAuthor(UserEntity author);
}
