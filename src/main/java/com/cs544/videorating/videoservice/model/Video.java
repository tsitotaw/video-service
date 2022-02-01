package com.cs544.videorating.videoservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Genre cannot be blank")
    private String genre;
    @Temporal(TemporalType.DATE)
    @Past(message = "Release date must be in the past")
    private Date releaseDate;
    private Long ratingId;

}
