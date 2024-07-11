package org.example.Service;

import org.example.entity.ChoiceQues;
import org.example.entity.ClassRoom;

import java.util.List;


public interface ChoiceQuesService {

    boolean insertChoiceQuesIntoQuestionBank(ChoiceQues choiceQue);

    boolean deletechoiceQuesByQuesInfoId(int quesInfoId);
}
