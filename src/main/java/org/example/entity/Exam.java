package org.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 试卷表
 * **/
@Data
@Getter
@Setter
public class Exam {
    private int id;
    private String examName;
    private int subjectId;
    private String createTime;
    private String className;
    private int createTeacher;
    private String type;
    private String duration;
    private int examId;

}
