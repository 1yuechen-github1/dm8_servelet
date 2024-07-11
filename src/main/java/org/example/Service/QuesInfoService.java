package org.example.Service;

//import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.QuesInfo;

import java.util.List;

public interface QuesInfoService {
    boolean insertQuesIntoQuestionBank(QuesInfo quesInfo);

    List<QuesInfo> queryAllQuestionsByPager(int offset,int size);

    QuesInfo queryQuestionInfoByQuesInfoId(int quesInfoId);

    boolean deleteQuestionIndoByQuesInfoId(int quesInfoId);

    boolean addQuesInfo(QuesInfo quesInfo);

    List<QuesInfo>   randomSubjQues(int subjQues);

    List<QuesInfo> randomTrueFalsejQues(int trueFalse);

    List<QuesInfo> randomMutipleQues(int mutipleQues);

    List<QuesInfo> queryAllQues(int subjectId);
}
