package com.example.entities.services;


import com.example.entities.Joke;
import com.example.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JokeService {
    @Autowired
    JokeRepository jokeRepository;

    public JokeService() {}

    public JokeService(JokeRepository carRepository) {

        this.jokeRepository= carRepository;
    }


    public List<Joke> getAllJokes() {
        return this.jokeRepository.findAll();
    }


    public Joke createJokes(Joke joke) {

        return jokeRepository.save(joke);

    }



}






