package com.seniorProject.deendiscovery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seniorProject.deendiscovery.model.entity.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Course {
    @Id // makes id the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // represents the data for what a course would have
    private Long id ;
    private String courseCode;
    private String title;
    private String description;
    private String instructor;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @JsonFormat(pattern = "MM-dd-yyyy")
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private Level level;

}

