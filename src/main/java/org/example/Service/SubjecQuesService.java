package org.example.Service;


import org.example.entity.SubjecQues;

public interface SubjecQuesService {
    boolean insertSubjecQuesintoQuestionBank(SubjecQues ques);

    boolean deleteSubjecQuesByQuesInfoId(int quesInfoId);
}
