package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.TurnInPapers;

import java.util.List;

@Mapper
public interface ExamPaperLibraryMapper {
    List<TurnInPapers> queryTurnInPapers();
}
