package com.pdev.blogPost.Blog.controller;

import com.pdev.blogPost.Blog.model.Post;
import com.pdev.blogPost.Blog.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<?> createPost(@RequestBody Post post){
    try {
        Post createdPost = postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    } catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

    @GetMapping()
    public ResponseEntity<List<Post>> getPosts(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getById(@PathVariable Long postId){
        try{

            return ResponseEntity.ok(postService.getPostById(postId));
        }catch (Exception e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("like/{postId}")
    public ResponseEntity<?> getLikes(@PathVariable Long postId){
        try{
            postService.likePost(postId);
            return ResponseEntity.ok(new String[] {"Post liked successfully..."});
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(postService.searchByName(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
