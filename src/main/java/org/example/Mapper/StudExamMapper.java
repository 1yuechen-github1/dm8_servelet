package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Exam;
import org.example.entity.ExamQuesInfo;
import org.example.entity.StudExam;

import java.util.List;

@Mapper
public interface StudExamMapper {
    boolean addStudAnsoIntoStudExam(ExamQuesInfo examQuesInfo);

    List<ExamQuesInfo> queryAllSubjectiveQuestions(int examId);

    boolean updateStudAnsoIntoStudExam(int score,int userId,int questionId);

    List<ExamQuesInfo> queryExamQuesByexamId(int examId);

    StudExam queryExamQuesByexamIdUserId(int userId, int examId, String type,int questionId);

    boolean updateStudAnsosIntoStudExam(ExamQuesInfo examQuesInfo);

    List<Exam> queryExamByExamIdAndCourseId(String className, int subjectId);

    boolean insertStudAnsoIntoStudExam(int userId, int score);

    int updateOneStudAnsoIntoStudExam(int score, int userId, int questionId, String myAnso,int examId);
}
