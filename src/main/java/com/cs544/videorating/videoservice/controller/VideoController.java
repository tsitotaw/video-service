package com.cs544.videorating.videoservice.controller;

import com.cs544.videorating.videoservice.dto.RatingVideoDTO;
import com.cs544.videorating.videoservice.model.Video;
import com.cs544.videorating.videoservice.service.IVideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private IVideoService movieService;

    @GetMapping("/")
    public List<Video> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/basic/{id}")
    public Video getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id);
    }

    @PostMapping("/")
    public Video saveMovie(@RequestBody @Valid Video video){
        return movieService.saveMovie(video);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }

    @GetMapping("/{id}")
    public RatingVideoDTO getVideoWithRating(@PathVariable Long id){
        return movieService.getVideoWithRating(id);
    }
}
