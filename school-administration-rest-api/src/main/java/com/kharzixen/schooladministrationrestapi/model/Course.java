package com.kharzixen.schooladministrationrestapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Course {
    @Id
    @SequenceGenerator(name = "EntityTwoSequence", initialValue = 1000)
    @GeneratedValue(generator = "EntityTwoSequence")
    private Long id;

    private String identifierFirstPart;
    private String name;
    private int nrOfCredits;

    //Document Syllabus;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    List<Teacher> teachers = new ArrayList<>();
}
