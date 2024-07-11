package org.example.Service;

import org.example.entity.TurnInPapers;

import java.util.List;

public interface ExamPaperLibraryService {
    List<TurnInPapers> queryTurnInPapers();
}
