package org.example.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.Exam;

import java.util.List;

@Data
@Getter
@Setter
public class ExamDto   {

    private Exam exam;
    private int count;//计算学生人数
    private int handInCount; //已经上交的学生人数

}
