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
    private Integer courseId;
    private String startTime;
    private String endTime;

}
