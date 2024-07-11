package org.example.Service.Impl;

import org.example.Mapper.SubjecQuesMapper;
import org.example.Service.SubjecQuesService;
import org.example.entity.SubjecQues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjecQuesServiceImpl implements SubjecQuesService {

    @Autowired
    private SubjecQuesMapper subjecQuesMapper;

    @Override
    public boolean insertSubjecQuesintoQuestionBank(SubjecQues ques) {
        return subjecQuesMapper.insertSubjecQuesintoQuestionBank(ques);
    }

    @Override
    public boolean deleteSubjecQuesByQuesInfoId(int quesInfoId) {
        return subjecQuesMapper.deleteSubjecQuesByQuesInfoId(quesInfoId);
    }
}
