package com.cs544.videorating.videoservice.service;

import com.cs544.videorating.videoservice.dto.RatingVideoDTO;
import com.cs544.videorating.videoservice.model.Video;

import java.util.List;

public interface IVideoService {
    List<Video> getAllMovies();
    Video getMovieById(Long id);
    Video saveMovie(Video video);
    void deleteMovieById(Long id);

    RatingVideoDTO getVideoWithRating(Long id);
}
