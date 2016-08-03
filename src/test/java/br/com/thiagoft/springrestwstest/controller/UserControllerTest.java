package br.com.thiagoft.springrestwstest.controller;

import br.com.thiagoft.springrestwstest.SpringRestwsTestApplicationTests;
import br.com.thiagoft.springrestwstest.dao.UserRepository;
import br.com.thiagoft.springrestwstest.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by thiagofonseca on 8/3/16.
 */
public class UserControllerTest extends SpringRestwsTestApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserRepository userRepository;

    private MockMvc mockMvc;

    private List<User> userList;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();

        userList = userRepository.listAll();
    }

    @Test
    public void getAllUserListTest() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].username",is(userList.get(0).getUsername())))
                .andExpect(jsonPath("$[0].password",is(userList.get(0).getPassword())))
                .andExpect(jsonPath("$[0].email",is(userList.get(0).getEmail())))
                .andExpect(jsonPath("$[1].username",is(userList.get(1).getUsername())))
                .andExpect(jsonPath("$[1].password",is(userList.get(1).getPassword())))
                .andExpect(jsonPath("$[1].email",is(userList.get(1).getEmail())));

    }

}
