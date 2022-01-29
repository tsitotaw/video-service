package com.cs544.videorating.videoservice.controller;

import com.cs544.videorating.videoservice.model.Rating;
import com.cs544.videorating.videoservice.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private IRatingService ratingService;

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("/{id}")
    public Rating getRatingById(@PathVariable Long id){
        return ratingService.getRatingById(id);
    }

    @PostMapping("/")
    public Rating saveRating(@RequestBody Rating rating){
        return ratingService.saveRating(rating);
    }

    @DeleteMapping("/{id}")
    public void deleteRatingById(@PathVariable Long id){
        ratingService.deleteRatingById(id);
    }

}
