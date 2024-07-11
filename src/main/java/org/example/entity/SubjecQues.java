package org.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *主观题
 * **/
@Data
@Getter
@Setter
public class SubjecQues extends QuesInfo{
    private int id;
    private int questionId;
    private String rightKey;
}
