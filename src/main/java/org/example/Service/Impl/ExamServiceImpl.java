package org.example.Service.Impl;

import org.example.Mapper.ExamMapper;
import org.example.Service.ExamService;
import org.example.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Override
    public int addExam(Exam exam) {
        return examMapper.addExam(exam);
    }
}
