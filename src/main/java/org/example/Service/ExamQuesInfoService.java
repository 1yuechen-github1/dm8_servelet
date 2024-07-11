package org.example.Service;

import org.example.common.R;
import org.example.entity.ExamQuesInfo;
import org.example.entity.QuesInfo;

import java.util.ArrayList;
import java.util.List;

public interface ExamQuesInfoService {
    boolean addQuesInfoIntoExam(ExamQuesInfo quesInfo);

    List<ExamQuesInfo> queryExamByExamId(int examId);

    boolean insertIntoExamQuesInfo(QuesInfo quesInfo);

    boolean addQuesInfoIntoExam1(ExamQuesInfo quesInfo1);

    R<ArrayList<QuesInfo>> queryExamPaperLibraryByExamId(int examId,int userId);

    ExamQuesInfo queryEveryQues(int quertionId,int userId);

    boolean updateObjectiveQuestionsScore(int examId,int userId);

    boolean queryByExamId(int id);

    int countStudent(int examId);

    List<ExamQuesInfo> queryExamPaperLibrarysByExamId(int userId, int examId);
}
