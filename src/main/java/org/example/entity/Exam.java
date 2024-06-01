package org.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Exam {
    private int id;
    private String name;
    private int courseId;
    private String startTime;
    private int createTeacher;
}
