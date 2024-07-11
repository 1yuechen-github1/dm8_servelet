package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.SubjecQues;

@Mapper
public interface SubjecQuesMapper {
    boolean insertSubjecQuesintoQuestionBank(SubjecQues ques);

    boolean deleteSubjecQuesByQuesInfoId(int quesInfoId);
}
