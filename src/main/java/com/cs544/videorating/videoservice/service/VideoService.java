package com.cs544.videorating.videoservice.service;

import com.cs544.videorating.videoservice.model.Video;
import com.cs544.videorating.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllMovies(){
        return videoRepository.findAll();
    }

    public Video getMovieById(Long id){
        return videoRepository.getById(id);
    }

    public Video saveMovie(Video video){
        return videoRepository.save(video);
    }

    public void deleteMovieById(Long id){
        videoRepository.deleteById(id);
    }

}
