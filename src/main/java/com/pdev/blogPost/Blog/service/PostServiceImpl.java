package com.pdev.blogPost.Blog.service;

import com.pdev.blogPost.Blog.model.Post;
import com.pdev.blogPost.Blog.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        post.setLikes(0);
        post.setViews(0);
        post.setDate(new Date());
       return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
       return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setViews(post.getViews()+ 1);
            return postRepository.save(post);

        }else {
            throw new EntityNotFoundException("Post not found with id: "+ postId);
        }

    }

    @Override
    public void likePost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            Post post = optionalPost.get();
            post.setLikes(post.getLikes() + 1);
            postRepository.save(post);
        }else{
            throw new EntityNotFoundException("Post not found with id: " + postId);
        }
    }

    public List<Post> searchByName(String title){
        return postRepository.findAllByTitleContaining(title);
    }
}
