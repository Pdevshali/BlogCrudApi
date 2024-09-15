package com.pdev.blogPost.Blog.repository;

import com.pdev.blogPost.Blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByTitleContaining(String title);
}
