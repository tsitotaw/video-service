package com.cs544.videorating.videoservice.bootstrap;

import com.cs544.videorating.videoservice.model.Video;
import com.cs544.videorating.videoservice.service.IVideoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrapper implements CommandLineRunner {
    @Autowired
    private IVideoService movieService;


    @Override
    public void run(String... args) throws Exception {
        this.movieService.saveMovie(new Video(null, "Breaking Bad", "Crime",new Date(2015,9,22)));
        this.movieService.saveMovie(new Video(null, "Kick Boxer", "Action",new Date(1997,6,30)));
    }
}
