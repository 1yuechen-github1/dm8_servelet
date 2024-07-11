package org.example.Service.Impl;

import org.example.Mapper.TrueFalseMapper;
import org.example.Service.TrueFalseService;
import org.example.entity.TrueFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrueFalseServiceImpl implements TrueFalseService {
    @Autowired
    private TrueFalseMapper trueFalseMapper;

    @Override
    public boolean insertTrueOrFalseintoQuestionBank(TrueFalse trueFalses) {
        return trueFalseMapper.insertTrueOrFalseintoQuestionBank(trueFalses);
    }

    @Override
    public boolean deleteTrueFalseQuesByQuesInfoId(int quesInfoId) {
        return trueFalseMapper.deleteTrueFalseQuesByQuesInfoId(quesInfoId);
    }
}
