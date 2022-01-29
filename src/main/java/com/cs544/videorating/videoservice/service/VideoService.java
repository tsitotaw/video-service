package com.cs544.videorating.videoservice.service;

import com.cs544.videorating.videoservice.dto.RatingVideoDTO;
import com.cs544.videorating.videoservice.model.Rating;
import com.cs544.videorating.videoservice.model.Video;
import com.cs544.videorating.videoservice.repository.RatingRepository;
import com.cs544.videorating.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private RatingRepository ratingRepository;

    public List<Video> getAllMovies(){
        return videoRepository.findAll();
    }

    public Video getMovieById(Long id){
        return videoRepository.findById(id).get();
    }

    public Video saveMovie(Video video){
        return videoRepository.save(video);
    }

    public void deleteMovieById(Long id){
        videoRepository.deleteById(id);
    }

    public RatingVideoDTO getVideoWithRating(Long id){
        RatingVideoDTO ratingVideoDTO = new RatingVideoDTO();
        Video video = videoRepository.findById(id).get();
        Rating rating = ratingRepository.findById(video.getRatingId()).get();
        ratingVideoDTO.setVideo(video);
        ratingVideoDTO.setRating(rating);
        return ratingVideoDTO;
    }

}
