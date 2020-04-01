package com.example.controller;



import com.example.entities.Category;
import com.example.entities.Joke;
import com.example.entities.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
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


    @GetMapping("/category")
    public List<Joke> getAllJokesByCategory(@PathVariable Category category){
        return jokeService.getAllJokesByCategory(category);
    }


    @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteJokeById(@PathVariable Long id){
            try {
                jokeService.deleteJokeById(id);
                return ResponseEntity.ok(("Deleted" + id);
            } catch (RecordNotFoundExcption e){


        }
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



