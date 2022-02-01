package com.cs544.videorating.videoservice.bootstrap;

import com.cs544.videorating.videoservice.model.Rating;
import com.cs544.videorating.videoservice.model.Video;
import com.cs544.videorating.videoservice.service.IRatingService;
import com.cs544.videorating.videoservice.service.IVideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Bootstrapper implements CommandLineRunner {
    @Autowired
    private IVideoService movieService;
    @Autowired
    private IRatingService ratingService;


    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("22/09/2015");
        this.movieService.saveMovie(new Video(null, "Breaking Bad", "Crime", date, 3L));
        this.movieService.saveMovie(new Video(null, "Kick Boxer", "Action", date, 4L));
        this.ratingService.saveRating(new Rating(null, 1L,4));
        this.ratingService.saveRating(new Rating(null, 2L, 3));
    }
}
