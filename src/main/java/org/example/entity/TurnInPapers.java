package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TurnInPapers {
    private int id;
    private String name;//学生姓名
    private String updateTime;
    private  int correctness;
    private  int status;
    private  int readTeacher;
    private  int grades;
}
