package com.example.controller;

import com.example.entities.Joke;
import com.example.entities.services.JokeService;
import javafx.beans.value.ObservableBooleanValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {


    final  JokeService jokeService;


     public JokeController(JokeService jokeService){
         this.jokeService= jokeService;
     }

       ResponseEntity <Joke > createJoke(Joke joke) {
         return ResponseEntity.ok(jokeService.createJoke(joke));
    }

//     @PostMapping
//     ResponseEntity <Joke> createJoke(@RequestBody Joke joke){
//         return ResponseEntity.ok(jokeService.createJoke(joke));
//
//     }



}
