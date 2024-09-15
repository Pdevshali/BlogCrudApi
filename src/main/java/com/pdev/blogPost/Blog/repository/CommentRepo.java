package com.pdev.blogPost.Blog.repository;

import com.pdev.blogPost.Blog.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {

    List<Comments> findByPostId(Long postId);

//    Comments findByPost_IdAndId(Long postId, Long commentId);

}
