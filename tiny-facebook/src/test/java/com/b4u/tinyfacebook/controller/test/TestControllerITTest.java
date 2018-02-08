package com.b4u.tinyfacebook.controller.test;

import com.b4u.tinyfacebook.util.TestMockUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.File;

import static org.mockito.Matchers.anyObject;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author: hzy
 * @since:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@PrepareForTest(TestMockUtil.class)

public class TestControllerITTest {

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setup() {
    }

    @Test
    @Ignore
    public void testMockStatic() throws Exception {
        //given
        PowerMockito.mockStatic(TestMockUtil.class);
        BDDMockito.given(TestMockUtil.testMockStatic((File) anyObject())).willReturn("mock !!!");

        ResultActions resultActions = mockMvc.perform(get("/test/mock")
                .contentType(MediaType.APPLICATION_JSON));

        MvcResult mvcResult = resultActions.andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }

    @Test
    @Ignore
    public void testValidation() throws Exception {

        ResultActions resultActions = mockMvc.perform(get("/test/validation?status=12232")
                .contentType(MediaType.APPLICATION_JSON));

        MvcResult mvcResult = resultActions.andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());

    }


}
