package com.enessetere.lfw.develop;

import com.enessetere.lfw.post.Post;
import com.enessetere.lfw.post.PostService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Profile("develop")
@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
    private static final Post post1 = new Post.PostBuilder().firstName("Sebastian").lastName("Muszalski").address("xyz 12").profession("IT Specialist").specialization("Fullstack Developer, IT Administrator").description("Long story short passionate developer with fixing computers problems skills.").build();
    private final PostService postService;

    public Initializer(PostService postService) {
        this.postService = postService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        postService.addPost(post1);
        System.out.println(postService.getAllPosts());
    }
}
