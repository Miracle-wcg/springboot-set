package com.wcg;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import wcg.controller.UserController;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author chengangw
 * @date 8/8/2017 2:19 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class HelloApplicationTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserControlelr() throws Exception {
        RequestBuilder request = null;

        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        request = post("/users/").param("id", "1").param("name", "aaa").param("age", "20");
        mockMvc.perform(request).andExpect(content().string(equalTo("success")));

        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"aaa\",\"age\":20}]")));

        request = put("/users/1")
                .param("name", "aaa")
                .param("age", "30");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = get("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"aaa\",\"age\":30}")));

        request = delete("/users/1");
        mockMvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = get("/users/");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
