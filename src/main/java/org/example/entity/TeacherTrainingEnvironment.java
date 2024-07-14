package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Data
@Getter
@Setter
public class TeacherTrainingEnvironment {
    private String title;
    private int courseId;
    private int teacherId;
    private int environmentId;
    private String startTime;
    private String endTime;
    private String type;
    private String content;
    private int id;
}
