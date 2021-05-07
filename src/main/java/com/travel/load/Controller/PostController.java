package com.travel.load.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.travel.load.Entity.Post;
import com.travel.load.Service.PostService;

import java.util.List;

@RestController
@RequestMapping(path = "post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping(path = "{postId}")
    public Post getPost(@PathVariable("postId") Long postId){
        return postService.getPost(postId);
    }


    @PostMapping
    public void addPost(@RequestBody Post post) {
        postService.addPost(post);
    }

    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

    @PutMapping(path = "{postId}")
    public void updatePost(@PathVariable("postId") Long postId,@RequestBody Post newPost) {
        postService.updatePost(postId, newPost.getTitle(), newPost.getContext());
    }
}
