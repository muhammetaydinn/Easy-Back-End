package com.example.Easy.Services;

import com.example.Easy.Entities.NewsCategoryEntity;
import com.example.Easy.Entities.NewsEntity;
import com.example.Easy.Mappers.NewsCategoryMapper;
import com.example.Easy.Models.NewsCategoryDTO;
import com.example.Easy.Models.NewsDTO;
import com.example.Easy.Repository.NewsCategoryRepository;
import com.example.Easy.Repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsCategoryService {
    private final NewsCategoryRepository newsCategoryRepository;
    private final NewsCategoryMapper newsCategoryMapper;

    public void addNewCategory(NewsCategoryDTO newsCategoryDTO) {
        NewsCategoryEntity newsCategoryEntity = newsCategoryMapper.toNewsCategoryEntity(newsCategoryDTO);
        newsCategoryRepository.save(newsCategoryEntity);
    }

    public NewsCategoryDTO getNewsCategoryById(Long categoryId) {
        return newsCategoryMapper.toNewsCategoryDTO(newsCategoryRepository.findById(categoryId).orElse(null));
    }

    public List<NewsCategoryDTO> getAllCategories() {
        return newsCategoryRepository.findAll()
                .stream().map(newsCategoryMapper::toNewsCategoryDTO)
                .collect(Collectors.toList());
    }

    public List<NewsCategoryDTO> getAllRoots() {
        return newsCategoryRepository.findByparent(null)
                .stream().map(newsCategoryMapper::toNewsCategoryDTO)
                .collect(Collectors.toList());
    }

    public Map<String,Map> mapjson(){
        List<NewsCategoryDTO> newsCategoryDTOS = getAllRoots();
        Map<String,Map> map = new HashMap<>();
        for(NewsCategoryDTO root : newsCategoryDTOS){
            if(root.getChildren().isEmpty())
                map.put(root.getName(),null);
            else {
                for(NewsCategoryEntity children : root.getChildren())
                    map.put(root.getName(),recursive(children));
            }
        }
        return map;
    }
    public Map<String,Map> recursive(NewsCategoryEntity news){
        Map<String,Map> map = new HashMap<>();
        if(news .getChildren().isEmpty()){
            map.put(news.getName(),null);
            return map;
        }
        for(NewsCategoryEntity children : news.getChildren()){
            map.put(news.getName(),recursive(children));
        }
        return map;
    }

    public Set<NewsEntity> getCategoryNews(NewsCategoryDTO newsCategoryDTO) {
        Set<NewsEntity> newsEntities = new HashSet<>(Set.copyOf(newsCategoryDTO.getNews()));
        for(NewsCategoryEntity children: newsCategoryDTO.getChildren()){
            if(!children.getChildren().isEmpty())
                newsEntities.addAll(getCategoryNews(newsCategoryMapper.toNewsCategoryDTO(children)));
        }
        return newsEntities;
    }
}
