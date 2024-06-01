package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Exam;

@Mapper
public interface ExamMapper {

    int addExam(Exam exam);
}
