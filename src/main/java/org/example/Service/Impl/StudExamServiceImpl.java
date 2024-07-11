package org.example.Service.Impl;

import org.example.Mapper.StudExamMapper;
import org.example.Service.StudExamService;
import org.example.entity.Exam;
import org.example.entity.ExamQuesInfo;
import org.example.entity.StudExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudExamServiceImpl implements StudExamService {

    @Autowired
    private StudExamMapper studExamMapper;

    @Override
    public boolean addStudAnsoIntoStudExam(ExamQuesInfo examQuesInfo) {
        int userId = examQuesInfo.getUserId();
        int examId = examQuesInfo.getExamId();
        String type = examQuesInfo.getType();
        int questionId = examQuesInfo.getQuestionId();
        StudExam studExams = studExamMapper.queryExamQuesByexamIdUserId(userId,
                examId,
                type,
                questionId);
        if (studExams==null){
            return studExamMapper.addStudAnsoIntoStudExam(examQuesInfo);
        }
        else {
           int i= studExamMapper.updateOneStudAnsoIntoStudExam(examQuesInfo.getScore(),
                   userId, questionId,examQuesInfo.getMyAnso()
                   , examId);

           System.out.println("改变了"+i+"条数据");
           if(i>0){
               return true;
           }
            return false;
        }
    }

    @Override
    public List<ExamQuesInfo>  queryAllSubjectiveQuestions(int examId) {
        return studExamMapper.queryAllSubjectiveQuestions(examId);
    }

    @Override
    public boolean updateStudAnsoIntoStudExam(int score,int userId,int questionId) {
        return studExamMapper.updateStudAnsoIntoStudExam( score, userId, questionId);
    }

    @Override
    public List<ExamQuesInfo> queryExamQuesByexamId(int examId) {
        return studExamMapper.queryExamQuesByexamId(examId);
    }

//    @Override
//    public List<StudExam> queryExamQuesByexamIdUserId(int userId, int examId, String type) {
//        return null;
//    }

//    @Override
//    public List<StudExam> queryExamQuesByexamIdUserId(int userId, int examId, String type) {
//        return studExamMapper.queryExamQuesByexamIdUserId(userId,  examId,  type);
//    }

    @Override
    public boolean updateStudAnsosIntoStudExam(ExamQuesInfo examQuesInfo) {
        return studExamMapper.updateStudAnsosIntoStudExam(examQuesInfo);
    }

    @Override
    public List<Exam> queryExamByExamIdAndCourseId(String className, int subjectId) {
        return studExamMapper.queryExamByExamIdAndCourseId( className, subjectId);
    }

    @Override
    public boolean insertStudAnsoIntoStudExam(int userId, int examId, int score) {
        return studExamMapper.insertStudAnsoIntoStudExam(userId,score);
    }
}
