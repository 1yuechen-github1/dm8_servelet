package org.example.Service.Impl;

import org.example.Mapper.ExamMapper;
import org.example.Service.ExamService;
import org.example.entity.Exam;
import org.example.entity.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Override
    public int addExam(Exam exam) {
        return examMapper.addExam(exam);
    }

    @Override
    public List<Exam> getAllExams(int offset,int size) {
        return examMapper.getAllExams(offset,size);
    }

    @Override
    public Exam queryExamByExamId(int examId) {
        return examMapper.queryExamByExamId(examId);
    }

    @Override
    public int addExamToRelatedExam(Exam exam) {
        return examMapper.addExamToRelatedExam(exam);
    }

    @Override
    public PageBean  getAllExamsByCourseId(int offset, int size, int subjectId) {
        PageBean pageBean =new PageBean();
        List<Exam> examList=examMapper.getAllExamBySubjectId(subjectId);
        pageBean.setTotal((long) examList.size());
        pageBean.setRows(examMapper.getAllExamsByCourseId( offset,  size,  subjectId));
        return pageBean;
    }

    @Override
    public List<Exam> queryExamBySubjectId(int subjectId) {
        return examMapper.queryExamBySubjectId(subjectId);
    }

    @Override
    public void queryByExamId(int id) {
        List<Exam> examList= examMapper.queryByExamId(id);
    }

    @Override
    public boolean delCreateExam(int id) {
        //删除创建的考试
         examMapper.delCreateExam(id);
        //删除已经发布的考试
        examMapper.delRelatedExam(id);
        return true;
    }
}
