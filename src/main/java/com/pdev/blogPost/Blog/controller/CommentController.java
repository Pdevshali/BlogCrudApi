package com.pdev.blogPost.Blog.controller;

import com.pdev.blogPost.Blog.service.CommentService;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("comments/create")
    public ResponseEntity<?> createComments(@RequestParam Long postId, @RequestParam String postedBy, @RequestBody String content){
        try{
            String formattedContent = StringEscapeUtils.unescapeJava(content.trim());
            return ResponseEntity.ok(commentService.createComment(postId, postedBy, formattedContent));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }

    @GetMapping("comments/{postId}")
    public ResponseEntity<?> getCommentsById(@PathVariable Long postId){
        try {
            return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong..");
        }

    }

//    @GetMapping("/comments/{postId}/{id}")
//    public ResponseEntity<?> getCommentById(@PathVariable Long postId, @PathVariable Long id){
//        try{
//            return ResponseEntity.ok(commentService.getCommentByCommentId(postId, id));
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment not found");
//        }
//    }
}
