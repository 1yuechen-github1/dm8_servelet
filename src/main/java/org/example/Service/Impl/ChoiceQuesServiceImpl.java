package org.example.Service.Impl;

import org.example.Mapper.ChoiceQuesMapper;
import org.example.Service.ChoiceQuesService;
import org.example.entity.ChoiceQues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceQuesServiceImpl implements ChoiceQuesService {
    @Autowired
    private ChoiceQuesMapper choiceQuesMapper;

    @Override
    public boolean insertChoiceQuesIntoQuestionBank(ChoiceQues choiceQue) {
        return  choiceQuesMapper.insertChoiceQuesIntoQuestionBank(choiceQue);
    }

    @Override
    public boolean deletechoiceQuesByQuesInfoId(int quesInfoId) {
        return choiceQuesMapper.deletechoiceQuesByQuesInfoId(quesInfoId);
    }
}
