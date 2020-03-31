package com.example.service;

import antlr.build.Tool;
import com.example.controller.JokeController;
import com.example.entities.Joke;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static javafx.beans.binding.Bindings.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JokeControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    JokeController jokeController;


    String baseUrl = "/api/jokes";
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void createJokeTest() throws Exception {
        Long expected = 0L;

        Joke joke = new Joke(1L, "Lets joke");

        String newRaceJson = mapper.writeValueAsString(joke);
         when(jokeController.createJoke(ArgumentMatchers.any(Joke.class))).thenReturn(joke);

        mockMvc.perform(post(baseUrl).content(newRaceJson).contentType(MediaType.APPLICATION_JSON))

                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.id").value(joke.getId()))
                 .andExpect(jsonPath("$.longtext").value(joke.getLongtext()));

    }

}
