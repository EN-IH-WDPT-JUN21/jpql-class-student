package com.ironhack.StudentSystem.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_name")
    private String studentName;

    @Column(name = "section_id")
    private String sectionId;

    private Integer score;

    public Grade(String studentName, String sectionId, Integer score) {
        this.studentName = studentName;
        this.sectionId = sectionId;
        this.score = score;
    }
}
