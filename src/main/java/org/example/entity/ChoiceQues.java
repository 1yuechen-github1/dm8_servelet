package org.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 选择题
 * **/
@Data
@Getter
@Setter
public class ChoiceQues extends QuesInfo{
    private int id;
    private int questionId;
    private String rightKey;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
}
