package com.pdev.blogPost.Blog.service;

import com.pdev.blogPost.Blog.model.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long postId);
    void likePost(Long postId);
    List<Post> searchByName(String title);

    }
