package com.example.Easy.Services;

import com.example.Easy.Mappers.CommentMapper;
import com.example.Easy.Models.CommentDTO;
import com.example.Easy.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    public void postComment(CommentDTO commentDTO) {
        commentRepository.save(commentMapper.toCommentEntity(commentDTO));
    }
}
