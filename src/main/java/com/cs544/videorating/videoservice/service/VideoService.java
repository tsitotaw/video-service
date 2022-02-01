package com.cs544.videorating.videoservice.service;

import com.cs544.videorating.videoservice.dto.RatingVideoDTO;
import com.cs544.videorating.videoservice.dto.User;
import com.cs544.videorating.videoservice.model.Rating;
import com.cs544.videorating.videoservice.model.Video;
import com.cs544.videorating.videoservice.repository.RatingRepository;
import com.cs544.videorating.videoservice.repository.VideoRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@Transactional
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Value("${user.credential}")
    private String credential;

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

        ResponseEntity<User> response = new RestTemplate()
                .exchange("http://localhost:9111/users/" + rating.getUserId(), HttpMethod.GET, this.getProperAuthorizationHeader(), User.class);
        User user = response.getBody();

        ratingVideoDTO.setVideo(video);
        ratingVideoDTO.setRating(rating);
        ratingVideoDTO.setUser(user);
        return ratingVideoDTO;
    }

    private String getBase64Credential(){
        String plainCreds = this.credential.substring(1, this.credential.length()-1);
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    private HttpEntity<User> getProperAuthorizationHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + this.getBase64Credential());
        return new HttpEntity<User>(headers);
    }

}
