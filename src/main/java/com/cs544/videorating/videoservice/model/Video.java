package com.cs544.videorating.videoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String genre;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

}
