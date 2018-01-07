package com.b4u.tinyfacebook.controller.post;

import com.b4u.tinyfacebook.dto.post.PostCreateDTO;
import com.b4u.tinyfacebook.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Compare with version 1, we
 * 1 use real database
 * 2 add more detail for the process logic
 *
 * @author: hzy
 * @since:
 */
@RestController
@RequestMapping("/v2.0/posts")
public class PostControllerV2 {

    @Autowired
    private PostService postService;

    @RequestMapping(value="", method= RequestMethod.POST)
    public ResponseEntity createPost(@RequestBody PostCreateDTO postCreateDTO) {
        return postService.createPost(postCreateDTO);
    }

}
