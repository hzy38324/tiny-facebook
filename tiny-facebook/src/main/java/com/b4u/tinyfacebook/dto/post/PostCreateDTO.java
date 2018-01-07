package com.b4u.tinyfacebook.dto.post;

import java.util.Date;

/**
 * <p>
 *
 * @author: hzy created on 2018/01/06
 */
public class PostCreateDTO {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostCreateDTO(String content) {
        this.content = content;
    }

    public PostCreateDTO() {
    }
}
