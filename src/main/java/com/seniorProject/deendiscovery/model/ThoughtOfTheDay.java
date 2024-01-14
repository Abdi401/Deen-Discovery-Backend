package com.seniorProject.deendiscovery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class ThoughtOfTheDay {
    @Id // makes id the primary key
    @GeneratedValue // it will make the ID auto generate
    private Long id; // represents the unique id for that model
    private String thought; // represents the thought of the day and will

}
