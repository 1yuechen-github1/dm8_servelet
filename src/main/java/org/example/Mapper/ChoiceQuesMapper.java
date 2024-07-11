package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.ChoiceQues;

@Mapper
public interface ChoiceQuesMapper {
    public boolean insertChoiceQuesIntoQuestionBank(ChoiceQues choiceQue) ;

    boolean deletechoiceQuesByQuesInfoId(int quesInfoId);
}
