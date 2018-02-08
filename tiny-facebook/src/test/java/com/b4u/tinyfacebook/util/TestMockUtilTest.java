package com.b4u.tinyfacebook.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

/**
 * <p>
 *
 * @author: hzy created on 2018/02/08
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(TestMockUtil.class)
public class TestMockUtilTest {

    @Test
    public void testMockMethod1(){
        //given
        PowerMockito.mockStatic(TestMockUtil.class);
        BDDMockito.given(TestMockUtil.testMockStatic()).willReturn("mock !!!");

        System.out.println(TestMockUtil.testMockStatic());

        //then
        PowerMockito.verifyStatic();
        System.out.println(TestMockUtil.testMockStatic());
    }

    @Test
    public void testMockMethod2(){
        //given
        PowerMockito.mockStatic(TestMockUtil.class);
        BDDMockito.given(TestMockUtil.testMockStatic(anyString())).willReturn("mock !!!");

        System.out.println(TestMockUtil.testMockStatic("aa"));

        //then
        PowerMockito.verifyStatic();
        System.out.println(TestMockUtil.testMockStatic("aa"));
    }

    @Test
    public void testMockMethod3(){
        //given
        PowerMockito.mockStatic(TestMockUtil.class);
        BDDMockito.given(TestMockUtil.testMockStatic((File) anyObject())).willReturn("mock !!!");

        File o = new File("");
        System.out.println(TestMockUtil.testMockStatic(o));

        //then
        PowerMockito.verifyStatic();
        System.out.println(TestMockUtil.testMockStatic(o));
    }
}
