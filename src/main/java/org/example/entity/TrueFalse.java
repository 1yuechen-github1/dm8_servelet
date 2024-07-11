package org.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *判断题
 * **/
@Data
@Getter
@Setter
public class TrueFalse extends QuesInfo{
    private int id;
    private int questionId;
    private String rightKey;
    private String choiceTrue;
    private String choiceFalse;
}
