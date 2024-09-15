package com.pdev.blogPost.Blog.service;

import com.pdev.blogPost.Blog.model.Comments;

import java.util.List;

public interface CommentService {

    public Comments createComment(Long postId, String postedBy, String content);

   public List<Comments> getCommentsByPostId(Long postId);

//    public Comments getCommentByCommentId(Long postId, Long commentId);


    }
