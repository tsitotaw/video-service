package com.cs544.videorating.videoservice.dto;

import com.cs544.videorating.videoservice.model.Rating;
import com.cs544.videorating.videoservice.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingVideoDTO {
    private Video video;
    private Rating rating;
}
