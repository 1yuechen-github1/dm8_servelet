package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.ExamQuesInfo;
import org.example.entity.QuesInfo;

import java.util.List;

@Mapper
public interface ExamQuesInfoMapper {


//     boolean insertIntoExamQuesInfo(QuesInfo quesInfo)

    boolean addQuesInfoIntoExam(ExamQuesInfo quesInfo);

    List<ExamQuesInfo> queryExamByExamId(int examId);

    boolean addQuesInfoIntoExam1(ExamQuesInfo quesInfo1);

    ExamQuesInfo queryEveryQues(int quertionId,int userId);

    boolean addQuesInfoIntoExams(ExamQuesInfo quesInfo);

    List<ExamQuesInfo> queryTeachExamByExamId(int examId);

    List<ExamQuesInfo> getExamQuesByExamIdAndUserId(int examId, int userId);

    List<ExamQuesInfo> getTeaScoreByExamId(int examId);

    List<ExamQuesInfo> getStudScoreByExamId(int examId);

    int updateScoreByQuesIdAndExamId(int examId,int score,int userId,int questionId);

    List<ExamQuesInfo> queryByExamId(int id);

    int countStudent(int examId);

    List<ExamQuesInfo> queryExamPaperLibrarysByExamId(int userId, int examId);
}
