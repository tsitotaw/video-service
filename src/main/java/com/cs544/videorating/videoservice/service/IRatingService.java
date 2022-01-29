package com.cs544.videorating.videoservice.service;

import com.cs544.videorating.videoservice.model.Rating;

import java.util.List;

public interface IRatingService {
    Rating getRatingById(Long id);
    List<Rating> getAllRatings();
    Rating saveRating(Rating rating);
    void deleteRatingById(Long id);
}
