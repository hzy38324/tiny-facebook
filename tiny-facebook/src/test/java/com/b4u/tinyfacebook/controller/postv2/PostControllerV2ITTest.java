package com.b4u.tinyfacebook.controller.postv2;

import com.b4u.tinyfacebook.dto.post.PostCreateDTO;
import com.b4u.tinyfacebook.entity.Post;
import com.b4u.tinyfacebook.repository.PostRepository;
import com.b4u.tinyfacebook.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: hzy
 * @since:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerV2ITTest {

    public static final String POST_CONTENT_VALID = "post content test";
    public static final String POST_CONTENT_SENSITIVE = "post content test fuck";
    public static final String POST_URL = "/v2.0/posts";
    public static final String MOCK_USER = "mock user";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostRepository postRepository;

    @MockBean
    private UserService userService;

    @Before
    public void setup() {
        given(userService.queryCurrentUserName()).willReturn(MOCK_USER);
        postRepository.deleteAll();
    }

    @Test
    public void testMockUser() {
        assertEquals(MOCK_USER, userService.queryCurrentUserName());
    }

    @Test
    public void testCreatePost_withSensitiveInfo_returnBadRequest() throws Exception {
        ResultActions resultActions = sendCreatePostRequest(POST_CONTENT_SENSITIVE);

        checkCreateSensitivePostResult(resultActions);
    }

    @Test
    public void testCreatePost_returnSuccess() throws Exception {
        ResultActions resultActions = sendCreatePostRequest(POST_CONTENT_VALID);

        checkCreateValidPostResult(resultActions, POST_CONTENT_VALID);
    }

    private void checkCreateSensitivePostResult(ResultActions resultActions) throws Exception {
        resultActions.andExpect(status().isBadRequest());

        long count = postRepository.count();
        assertEquals(0, count);
    }

    private ResultActions sendCreatePostRequest(String postContent) throws Exception {
        PostCreateDTO postCreateDTO = new PostCreateDTO(postContent);
        return mockMvc.perform(post(POST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postCreateDTO)));
    }

    private void checkCreateValidPostResult(ResultActions resultActions, String expectedContent) throws Exception {
        resultActions.andExpect(status().isCreated());

        Post postFromRsp = transferResponse2PostEntity(resultActions);
        Post postFromDB = postRepository.findOne(postFromRsp.getId());

        assertNotNull(postFromDB);
        assertEquals(expectedContent, postFromDB.getContent());
        assertEquals(MOCK_USER, postFromDB.getUsername());
    }

    private Post transferResponse2PostEntity(ResultActions resultActions) throws java.io.IOException {
        String response = resultActions.andReturn().getResponse().getContentAsString();
        return objectMapper.readValue(response, Post.class);
    }

}
