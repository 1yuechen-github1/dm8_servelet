package org.example.Service;

import org.example.entity.ChoiceQues;
import org.example.entity.TrueFalse;


public interface TrueFalseService {

    boolean insertTrueOrFalseintoQuestionBank(TrueFalse trueFalses);

    boolean deleteTrueFalseQuesByQuesInfoId(int quesInfoId);
}
