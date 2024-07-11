package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Exam;

import java.util.List;

@Mapper
public interface ExamMapper {

    int addExam(Exam exam);

    List<Exam> getAllExams(int offset,int size);

    Exam queryExamByExamId(int examId);

    int addExamToRelatedExam(Exam exam);

    List<Exam> getAllExamsByCourseId(int offset, int size, int subjectId);

    List<Exam> queryExamBySubjectId(int subjectId);

    List<Exam> getAllExam();

    List<Exam> getAllExamBySubjectId(int subjectId);

    List<Exam> queryByExamId(int id);

    boolean delCreateExam(int id);

    boolean delRelatedExam(int id);
}
