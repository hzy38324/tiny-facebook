package com.b4u.tinyfacebook.service.post;

import com.b4u.tinyfacebook.dto.post.PostCreateDTO;
import com.b4u.tinyfacebook.entity.Post;
import com.b4u.tinyfacebook.exception.ErrorInfo;
import com.b4u.tinyfacebook.repository.PostRepository;
import com.b4u.tinyfacebook.service.user.UserService;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/06
 */
@Service
public class PostService {

    public static final String POST_CONTAINS_SENSITIVE_INFO = "post contains sensitive info";
    public static final int SENSITIVE_INFO_ERROR_CODE = 100001;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public ResponseEntity createPost(PostCreateDTO postCreateDTO) {
        if(isPostContainsSensitiveInfo(postCreateDTO.getContent())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorInfo(SENSITIVE_INFO_ERROR_CODE, POST_CONTAINS_SENSITIVE_INFO));
        }
        Post postCreateResult = savePost2DB(postCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(postCreateResult);
    }

    private boolean isPostContainsSensitiveInfo(String content) {
        // TODO: change to throw exception and use global exception handler to return response
        if(content.contains("shit") || content.contains("fuck")) {
            return true;
        }
        return false;
    }

    private Post savePost2DB(PostCreateDTO postCreateDTO) {
        Post post = new Post();
        post.setCreateDate(new Date());
        post.setContent(postCreateDTO.getContent());
        post.setUsername(userService.queryCurrentUserName());
        return postRepository.save(post);
    }
}
