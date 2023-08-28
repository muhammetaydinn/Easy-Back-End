package com.example.Easy.Services;

import com.example.Easy.Entities.NewsEntity;
import com.example.Easy.Entities.UserEntity;
import com.example.Easy.Mappers.NewsMapper;
import com.example.Easy.Models.NewsDTO;
import com.example.Easy.Repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService {
    @Autowired
    UserService userService;

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public List<NewsDTO> getAllNews() {
        return newsRepository.findAll()
                .stream().map(newsMapper::toNewsDTO)
                .collect(Collectors.toList());
    }

    public List<NewsDTO> getNewsByTitle(String title) {
        return newsRepository.findByTitle(title)
                .stream().map(newsMapper::toNewsDTO)
                .collect(Collectors.toList());
    }
    public NewsDTO getNewsById(UUID newsId) {
        return newsMapper.toNewsDTO(newsRepository.findById(newsId).orElse(null));
    }

    public void postNews(NewsDTO newsDTO) {
        newsRepository.save(newsMapper.toNewsEntity(newsDTO));
    }

    public void deletePostById(UUID newsUUID) {
        newsRepository.deleteById(newsUUID);
    }






    public List<NewsDTO> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category)
                .stream().map(newsMapper::toNewsDTO)
                .collect(Collectors.toList());
    }
}
