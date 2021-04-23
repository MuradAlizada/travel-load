package com.travel.load.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travel.load.Entity.Post;
import com.travel.load.Repository.PostRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalStateException("post with id " + postId + " does not exists"));
    }

    public void addPost(Post post) {
        post.setPostDate(LocalDate.now());
        postRepository.save(post);
    }

    public void deletePost(Long postId) {
        boolean exists = postRepository.existsById(postId);
        if(!exists){
            throw new IllegalStateException("post with id " + postId + " does not exists");
        }
        postRepository.deleteById(postId);
    }

    @Transactional
    public void updatePost(Long postId, String title, String context) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new IllegalStateException("post with id " + postId + " does not exists"));

        if(title != null &&
                title.length() > 0 &&
                !Objects.equals(post.getTitle(), title))  {
            post.setTitle(title);
        }

        if(context != null &&
                context.length() > 0 &&
                !Objects.equals(post.getContext(), context))  {
            post.setContext(context);
        }

    }
}
