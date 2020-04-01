package com.example.service;


import com.example.entities.Category;
import com.example.entities.Joke;
import com.example.entities.services.JokeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class JokeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    JokeService jokeController;


    ObjectMapper mapper = new ObjectMapper();
    final String baseUrl = "/api/cars";
    @Test
    void createJokes() throws Exception {


        Joke joke = new Joke( "Lets joke", Category.DADJOKES);

        String newCarJson = mapper.writeValueAsString(joke);
        when(jokeController.createJokes(ArgumentMatchers.any(Joke.class))).thenReturn(joke);

        mockMvc.perform(post(baseUrl).content(newCarJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(joke.getId()))
                .andExpect(jsonPath("$.longtext").value(joke.getLongtext()))
                .andExpect(jsonPath("$.category").value(joke.getCategory()));
    }


    @Test
    void getAllJokes() throws Exception {

        //Setup
        ArrayList<Joke> jokes = new ArrayList<>();
        Joke joke = new Joke();
        jokes.add(joke);
        when(jokeController.getAllJokes()).thenReturn(jokes);
        //Exercise
        mockMvc.perform(get(baseUrl).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(jokes.size())));

    }


    @Test
    void getAllJokesByCategory() throws Exception {

        // setup
        List<Joke> jokes = new ArrayList<>();

        Joke joke = new Joke();
        jokes.add(joke);

        //Exercise
        when(jokeController.getAllJokesByCategory(Category.DADJOKES)).thenReturn(jokes);
        mockMvc.perform(get(baseUrl).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }


    @Test
    void deleteJokeById(@PathVariable Long id) throws Exception {

        Joke joke = new Joke( "Lets joke", Category.DADJOKES);

        String newCarJson = mapper.writeValueAsString(joke);
        when(jokeController.deleteJokeById(ArgumentMatchers.any(Joke.class))).thenReturn(joke);

        mockMvc.perform(post(baseUrl).content(newCarJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(joke.getId()))
                .andExpect(jsonPath("$.longtext").value(joke.getLongtext()));


    }



}
