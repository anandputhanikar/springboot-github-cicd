package com.mytechapi.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentScan(basePackages="com.mytechapi")
@ContextConfiguration
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = BooksControllerTest.class)
class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private BooksController booksController;

    @BeforeEach
    public void setUp(){

        this.mockMvc = MockMvcBuilders.standaloneSetup(this.booksController).build();
    }

    @Test
    @Order(1)
    void test_getBooks() throws Exception {

//        fail("not implemented");

        String book = "getBooks() need to implement..!!";

        this.mockMvc.perform(get("/book/get"))
                .andExpect(status().isOk())
                .andExpect(content().string(book))
                .andDo(print())    ;

    }

    @Test
    @Order(2)
    void test_getBooksNegative() throws Exception {

        String book = "Need to implement..!!";

        this.mockMvc.perform(get("/book/get"))
                .andExpect(result -> new Exception())
                .andDo(print());

    }

    @Test
    @Order(3)
    void test_addBook() throws Exception {
        String bookName = "Spring in Action";

        this.mockMvc.perform(post("/book/add/{bookName}",bookName))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*]", Matchers.hasItem(bookName)))
                .andDo(print());

    }
}