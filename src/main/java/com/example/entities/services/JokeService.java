package com.example.entities.services;

import com.example.entities.Joke;
import com.example.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JokeService {

    @Autowired
    JokeRepository jokeRepository;


    public JokeService(){};

    public JokeService(JokeRepository jokeRepository){
        this.jokeRepository = jokeRepository;

    }

    public Joke createJoke(Joke joke) {
        return jokeRepository.save(joke);
    }

//    public Joke createJoke(Joke joke) {
//        return jokeRepository.save(joke);
//
//    }
}
