package com.pdev.blogPost.Blog.service;

import com.pdev.blogPost.Blog.model.Comments;
import com.pdev.blogPost.Blog.model.Post;
import com.pdev.blogPost.Blog.repository.CommentRepo;
import com.pdev.blogPost.Blog.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepository postRepository;

    public Comments createComment(Long postId, String postedBy, String content){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()){
            Comments comment = new Comments();
            comment.setPost(optionalPost.get());
            comment.setContent(content);
            comment.setPostedBy(postedBy);
            comment.setCurrentAt(new Date());

           return commentRepo.save(comment);

        }else {
            throw new EntityNotFoundException("Post not found");
        }
    }

    public List<Comments> getCommentsByPostId(Long postId){
        return commentRepo.findByPostId(postId);
    }

//    public Comments getCommentByCommentId(Long postId, Long commentId) {
//        return commentRepo.findByPost_IdAndId(postId, commentId);
//    }
}
