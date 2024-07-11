package org.example.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.QuesInfo;

import java.util.List;

@Mapper
public interface QuesInfoMapper extends BaseMapper<QuesInfo> {
    boolean insertQuesIntoQuestionBank(QuesInfo quesInfo);

    List<QuesInfo> queryAllQuestionsByPager(int offset,int size);

    QuesInfo queryQuestionInfoByQuesInfoId(int quesInfoId);

    boolean deleteQuestionIndoByQuesInfoId(int quesInfoId);

    boolean addQuesInfo(QuesInfo quesInfo);

    List<QuesInfo>  randomSubjQues(int subjQues);

    List<QuesInfo> randomTrueFalsejQues(int trueFalse);

    List<QuesInfo> randomMutipleQues(int mutipleQues);

    List<QuesInfo> queryAllQues(int subjectId);
}
