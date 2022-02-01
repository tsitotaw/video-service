package com.cs544.videorating.videoservice.service;

import com.cs544.videorating.videoservice.model.Rating;
import com.cs544.videorating.videoservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RatingService implements IRatingService{
    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating){
        return ratingRepository.save(rating);
    }

    public Rating getRatingById(Long id){
        return ratingRepository.findById(id).get();
    }

    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    public void deleteRatingById(Long id){
        ratingRepository.deleteById(id);
    }
}
