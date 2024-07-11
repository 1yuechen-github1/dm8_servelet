package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExamQuesInfo {
    private int id;
    private int examId;
    private String type;
    private int questionId;
    private int score;
    private int userId;
    private String myAnso;

}
