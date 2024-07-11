package org.example.Service;

import org.example.entity.Exam;
import org.example.entity.PageBean;

import java.util.List;

public interface ExamService {
    int addExam(Exam exam);

    List<Exam> getAllExams(int offset,int size);

    Exam queryExamByExamId(int examId);

    int addExamToRelatedExam(Exam exam);

    PageBean  getAllExamsByCourseId(int offset, int size, int subjectId);

    List<Exam> queryExamBySubjectId(int subjectId);

    void queryByExamId(int id);

    boolean delCreateExam(int id);
}
