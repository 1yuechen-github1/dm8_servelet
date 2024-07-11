package org.example.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.Mapper.QuesInfoMapper;
import org.example.Service.QuesInfoService;
import org.example.entity.QuesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuesInfoServiceImpl implements QuesInfoService {
    @Autowired
    private QuesInfoMapper quesInfoMapper;

    @Override
    public boolean insertQuesIntoQuestionBank(QuesInfo quesInfo) {
        return quesInfoMapper.insertQuesIntoQuestionBank(quesInfo);
    }

    @Override
    public List<QuesInfo> queryAllQuestionsByPager(int offset,int size) {
        return quesInfoMapper.queryAllQuestionsByPager( offset,size);
    }

    @Override
    public QuesInfo queryQuestionInfoByQuesInfoId(int quesInfoId) {
        return quesInfoMapper.queryQuestionInfoByQuesInfoId( quesInfoId);
    }

    @Override
    public boolean deleteQuestionIndoByQuesInfoId(int quesInfoId) {
        return quesInfoMapper.deleteQuestionIndoByQuesInfoId(quesInfoId);
    }

    @Override
    public boolean addQuesInfo(QuesInfo quesInfo) {
        return quesInfoMapper.addQuesInfo(quesInfo);
    }



    @Override
    public List<QuesInfo>  randomSubjQues(int subjQues) {
        return quesInfoMapper.randomSubjQues(subjQues);
    }

    @Override
    public List<QuesInfo> randomTrueFalsejQues(int trueFalse) {
        return quesInfoMapper.randomTrueFalsejQues(trueFalse);
    }

    @Override
    public List<QuesInfo> randomMutipleQues(int mutipleQues) {
        return quesInfoMapper.randomMutipleQues(mutipleQues);
    }

    @Override
    public List<QuesInfo> queryAllQues(int subjectId) {
        return quesInfoMapper.queryAllQues(subjectId);
    }


}
