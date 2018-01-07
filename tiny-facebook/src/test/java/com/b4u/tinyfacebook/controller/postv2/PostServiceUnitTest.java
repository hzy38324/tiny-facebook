package com.b4u.tinyfacebook.controller.postv2;

import com.b4u.tinyfacebook.service.post.PostService;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/06
 */
public class PostServiceUnitTest {

    @Test
    public void testMethod_IsPostContainsSensitiveInfo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<PostService> postServiceClass = PostService.class;
        Method method = postServiceClass.getDeclaredMethod("isPostContainsSensitiveInfo", String.class);
        method.setAccessible(true);

        PostService postService = new PostService();
        checkWithContent(method, postService, "hi and fuck", true);
        checkWithContent(method, postService, "hello world", false);
        checkWithContent(method, postService, "hello shit", true);

    }

    private void checkWithContent(Method method, PostService postService, String content, boolean expected) throws IllegalAccessException, InvocationTargetException {
        boolean isSensitive = (Boolean)method.invoke(postService, content);
        assertEquals(expected, isSensitive);
    }
}
