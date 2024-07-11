package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.TrueFalse;

@Mapper
public interface TrueFalseMapper {
    boolean insertTrueOrFalseintoQuestionBank(TrueFalse trueFalses);

    boolean deleteTrueFalseQuesByQuesInfoId(int quesInfoId);
}
