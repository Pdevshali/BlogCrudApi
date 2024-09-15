package com.pdev.blogPost.Blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date currentAt;

    private String postedBy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comments() {
    }

    public Comments(Long id, String content, Date currentAt, String postedBy, Post post) {
        this.id = id;
        this.content = content;
        this.currentAt = currentAt;
        this.postedBy = postedBy;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCurrentAt() {
        return currentAt;
    }

    public void setCurrentAt(Date currentAt) {
        this.currentAt = currentAt;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", currentAt=" + currentAt +
                ", postedBy='" + postedBy + '\'' +
                ", post=" + post +
                '}';
    }
}
