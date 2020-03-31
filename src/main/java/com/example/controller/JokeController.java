package com.example.controller;



import com.example.entities.Joke;
import com.example.entities.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class JokeController {

    final JokeService jokeService;



    @Autowired
    public JokeController(JokeService carService){
        this.jokeService = carService;
    }

    @PostMapping
    ResponseEntity<Joke> createJokes(@RequestBody Joke joke) {

        return ResponseEntity.ok(jokeService.createJokes(joke));
    }


    @GetMapping
    ResponseEntity<List<Joke>> getAllJokes(){
        return ResponseEntity.ok(jokeService.getAllJokes());

    }

//
//    @GetMapping("/{id}")
//    public ResponseEntity<Car> getOrderById(@PathVariable Long id){
//        Car car = jokeService.getCarById(id);
//        return ResponseEntity.ok(car);
//    }
//
//     @DeleteMapping("/{id}")
//    public ResponseEntity<Car> deleteCar(@PathVariable Long id){
//        Car car = jokeService.getCarById(id);
//
//        return ResponseEntity.ok(car);
//
//
//        }






    }



