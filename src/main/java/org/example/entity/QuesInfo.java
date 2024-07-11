package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

/**
 * 题目类型表
 * **/
public class QuesInfo {
    private int id;
    private String type;
    private String level;
    private int courseId;
    private int teacherId;
    private String uploadTime;
    private String topicContent;
    private String rightKey;
    private String choice;
    private int score;
}
