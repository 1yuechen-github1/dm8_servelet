package org.example.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.Mapper.ExamQuesInfoMapper;
import org.example.Mapper.QuesInfoMapper;
import org.example.Service.ExamQuesInfoService;
import org.example.common.R;
import org.example.entity.ExamQuesInfo;
import org.example.entity.QuesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ExamQuesInfoServiceImpl implements ExamQuesInfoService {
    @Autowired
    private ExamQuesInfoMapper examQuesInfoMapper;

    @Autowired
    private QuesInfoMapper quesInfoMapper;

    @Override
    public boolean addQuesInfoIntoExam(ExamQuesInfo quesInfo) {
        return examQuesInfoMapper.addQuesInfoIntoExam( quesInfo);
    }

    @Override
    public List<ExamQuesInfo> queryExamByExamId(int examId) {
        return examQuesInfoMapper.queryExamByExamId(examId);
    }

    @Override
    public boolean insertIntoExamQuesInfo(QuesInfo quesInfo) {
//        return ExamQuesInfoMapper.insertIntoExamQuesInfo(quesInfo);
        return false;
    }

    @Override
    public boolean addQuesInfoIntoExam1(ExamQuesInfo quesInfo1) {
        return examQuesInfoMapper.addQuesInfoIntoExam1(quesInfo1);
    }


    @Override
    public R queryExamPaperLibraryByExamId(int examId,int userId) {
        //学生第一次进入答题

        //学生第二次进入答题
        List<ExamQuesInfo> examQuesInfos1 = examQuesInfoMapper.getExamQuesByExamIdAndUserId(examId, userId);
        ArrayList<QuesInfo> examQuesInfos = new ArrayList<>();
        //应该返回历史做题的内容（题目加答案）
        //在进入考试的地方已经新建且设置userId的值，所有这里不用新建
        //可以直接查询后返回？
        if (!examQuesInfos1.isEmpty()) {
            for (ExamQuesInfo examQuesInfo : examQuesInfos1) {
                int questionId = examQuesInfo.getQuestionId();
                QuesInfo quesInfo = quesInfoMapper.queryQuestionInfoByQuesInfoId(questionId);
                examQuesInfos.add(quesInfo);
            }
            return R.success(examQuesInfos);

        } else {
            List<ExamQuesInfo> quesInfos = examQuesInfoMapper.queryTeachExamByExamId(examId);
            examQuesInfos = new ArrayList<>();
            for (ExamQuesInfo examQuesInfo : quesInfos) {
                int questionId = examQuesInfo.getQuestionId();
                QuesInfo info = quesInfoMapper.queryQuestionInfoByQuesInfoId(questionId);
                examQuesInfo.setUserId(userId);
                boolean i = examQuesInfoMapper.addQuesInfoIntoExams(examQuesInfo);
                examQuesInfos.add(info);


            }
            return R.success(examQuesInfos);
        }

    }
    @Override
    public ExamQuesInfo queryEveryQues(int quertionId, int userId) {
        return examQuesInfoMapper.queryEveryQues(quertionId ,userId);
    }

//    @Override
//    public boolean updateObjectiveQuestionsScore(int examId,int userId) {
//        //先校对答案
//        //查询学生写的内容
//        //这里的userId 是学生的id
//        List<ExamQuesInfo> examQuesInfos = examQuesInfoMapper.getExamQuesByExamIdAndUserId(examId, userId);
//        //遍历得到每一题
//        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
//            int score = 0;
//            //查询题库表得到正确答案
//            int questionId = examQuesInfo.getQuestionId();
//            QuesInfo quesInfo = quesInfoMapper.queryQuestionInfoByQuesInfoId(questionId);
//            //校对答案和学生写的内容是否一样
//            if (quesInfo.getRightKey().length() ==examQuesInfo.getMyAnso().length()) {
//                // 将字符串转换为字符数组
//                char[] charArray1 = quesInfo.getRightKey().toCharArray();
//                char[] charArray2 = examQuesInfo.getMyAnso().toCharArray();
//                // 对字符数组进行排序
//                Arrays.sort(charArray1);
//                Arrays.sort(charArray2);
//                if (Arrays.equals(charArray1, charArray2)) {
////                正确
//                //score是查询userId（教师）得到的
//                List<ExamQuesInfo> teaScoreByExamId = examQuesInfoMapper.getTeaScoreByExamId(examId);
//                for (ExamQuesInfo info : teaScoreByExamId) {
//                    if (info.getQuestionId() == questionId) {
//                        score = info.getScore();
//                        int i =
//                                examQuesInfoMapper.updateScoreByQuesIdAndExamId(examId, score, userId, questionId);
//                    }
//                }
//            }
//            }
//            //得到多选题
//            else if (examQuesInfo.getType().equals("多选题")) {
//                //score是查询userId（教师）得到的
//                List<ExamQuesInfo> teaScoreByExamId = examQuesInfoMapper.getTeaScoreByExamId(examId);
//                QuesInfo quesInfo1 = quesInfoMapper.queryQuestionInfoByQuesInfoId(questionId);
//                String myAnso = examQuesInfo.getMyAnso();
//                char[] charArray1 = quesInfo.getRightKey().toCharArray();
//                char[] charArray2 = examQuesInfo.getMyAnso().toCharArray();
//                // 对字符数组进行排序
//                Arrays.sort(charArray1);
//                Arrays.sort(charArray2);
////                if (quesInfo1.getRightKey().contains(myAnso)){
////                if (quesInfo1.getRightKey().contains(myAnso)){
//                    for (ExamQuesInfo info : teaScoreByExamId) {
//                        if (info.getQuestionId() == questionId) {
//                int i = 0, j = 0;
//                while (i < charArray2.length && j < charArray1.length) {
//                    if (charArray2[i] == charArray1[j]) {
//                        i++; // 移动到charArray2的下一个元素
//                    }
//                    j++; // 无论是否匹配，都尝试在charArray1中查找下一个可能的匹配
//                }
//
//                // 如果i（即charArray2的指针）已经遍历完整个数组，说明charArray2中的所有元素都在charArray1中找到了匹配
//                boolean b = i == charArray2.length;
//                if ( b==true){
//                    score = info.getScore();
//                    int a = examQuesInfoMapper.updateScoreByQuesIdAndExamId(examId, score, userId, questionId);
//                } else if (i<=charArray2.length&&i>0) {
//                    score = info.getScore()/2;
//                    int a = examQuesInfoMapper.updateScoreByQuesIdAndExamId(examId, score, userId, questionId);
//                }
//                        }}
//            }
////                错误
//           else{
//               int i= examQuesInfoMapper.updateScoreByQuesIdAndExamId(examId,score,userId,questionId);
//            }
//        }
//        //返回结果
//        return true;
//    }
@Override
public boolean updateObjectiveQuestionsScore(int examId, int userId) {
    // 获取学生的答题信息
    List<ExamQuesInfo> examQuesInfos = examQuesInfoMapper.getExamQuesByExamIdAndUserId(examId, userId);
    // 获取教师的评分信息
    List<ExamQuesInfo> teaScoreByExamId = examQuesInfoMapper.getTeaScoreByExamId(examId);

    for (ExamQuesInfo examQuesInfo : examQuesInfos) {
        int score = 0;
        int questionId = examQuesInfo.getQuestionId();
        QuesInfo quesInfo = quesInfoMapper.queryQuestionInfoByQuesInfoId(questionId);

        // 检查答案是否正确
        if (isCorrectAnswer(quesInfo.getRightKey(), examQuesInfo.getMyAnso())) {
            score = getScore(teaScoreByExamId, questionId);
        } else if ("多选题".equals(examQuesInfo.getType())) {
            score = getPartialScore(quesInfo.getRightKey(), examQuesInfo.getMyAnso(), teaScoreByExamId, questionId);
        }
        // 更新得分
        examQuesInfoMapper.updateScoreByQuesIdAndExamId(examId, score, userId, questionId);
    }
    return true;
}

    @Override
    public boolean queryByExamId(int id) {
       List<ExamQuesInfo> examQuesInfos= examQuesInfoMapper.queryByExamId(id);
        for (ExamQuesInfo examQuesInfo : examQuesInfos) {
            String type = examQuesInfo.getType();
            if (type.equals("简答题")){
                return false;
            }
        }
        return true;
    }

    @Override
    public int countStudent(int examId) {
       return examQuesInfoMapper.countStudent(examId);
    }

    @Override
    public List<ExamQuesInfo> queryExamPaperLibrarysByExamId(int userId, int examId) {
        return examQuesInfoMapper.queryExamPaperLibrarysByExamId(userId,examId);
    }

    private boolean isCorrectAnswer(String rightKey, String myAnso) {
        char[] charArray1 = rightKey.toCharArray();
        char[] charArray2 = myAnso.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    private int getScore(List<ExamQuesInfo> teaScoreByExamId, int questionId) {
        for (ExamQuesInfo info : teaScoreByExamId) {
            if (info.getQuestionId() == questionId) {
                return info.getScore();
            }
        }
        return 0;
    }

    private int getPartialScore(String rightKey, String myAnso, List<ExamQuesInfo> teaScoreByExamId, int questionId) {
        char[] charArray1 = rightKey.toCharArray();
        char[] charArray2 = myAnso.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        int i = 0, j = 0;
        while (i < charArray2.length && j < charArray1.length) {
            if (charArray2[i] == charArray1[j]) {
                i++;
            }
            j++;
        }

        boolean allMatched = i == charArray1.length;
        int baseScore = getScore(teaScoreByExamId, questionId);
        if (allMatched) {
            return baseScore;
        } else if (i > 0) {
            return baseScore / 2;
        }
        return 0;
    }


}
