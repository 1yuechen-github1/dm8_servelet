package org.example.Service.Impl;

import org.example.Mapper.ExamPaperLibraryMapper;
import org.example.Service.ExamPaperLibraryService;
import org.example.entity.TurnInPapers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamPaperLibraryServiceImpl implements ExamPaperLibraryService {

    @Autowired
    private ExamPaperLibraryMapper examPaperLibraryMapper;


    @Override
    public List<TurnInPapers> queryTurnInPapers() {
        return examPaperLibraryMapper.queryTurnInPapers();
    }
}
