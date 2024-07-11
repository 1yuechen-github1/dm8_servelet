package org.example.Service;

import org.example.entity.Exam;
import org.example.entity.ExamQuesInfo;
import org.example.entity.StudExam;

import java.util.List;

public interface StudExamService {
    boolean addStudAnsoIntoStudExam(ExamQuesInfo examQuesInfo);

    List<ExamQuesInfo>  queryAllSubjectiveQuestions(int examId);

    boolean updateStudAnsoIntoStudExam(int score,int userId,int questionId);

    List<ExamQuesInfo> queryExamQuesByexamId(int examId);

//    List<StudExam> queryExamQuesByexamIdUserId(int userId, int examId, String type);

    boolean updateStudAnsosIntoStudExam(ExamQuesInfo examQuesInfo);

    List<Exam> queryExamByExamIdAndCourseId(String className, int subjectId);

    boolean insertStudAnsoIntoStudExam(int userId, int examId, int score);
}
