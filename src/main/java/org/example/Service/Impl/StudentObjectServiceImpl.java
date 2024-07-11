package org.example.Service.Impl;

import org.example.Mapper.StudentObjectMapper;
import org.example.Service.StudentObjectService;
import org.example.Service.StudentService;
import org.example.entity.StudentObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentObjectServiceImpl implements StudentObjectService {
    @Autowired
    private StudentObjectMapper studentObjectMapper;

    @Override
    public boolean delObjectAndStudebtBysubjectId(int subjectId) {
        return studentObjectMapper.delObjectAndStudebtBysubjectId(subjectId);
    }

    @Override
    public boolean delStudentCourseByCourseId( int userId,int courseId) {
        return studentObjectMapper.delStudentCourseByCourseId(userId,courseId);
    }

    @Override
    public List<StudentObject> queryAllStudentObject() {
        return studentObjectMapper.queryAllStudentObject();
    }

    @Override
    public boolean joinTheClass(int userId, int subjectId) {
        return studentObjectMapper.joinTheClass(userId,subjectId);
    }

    @Override
    public StudentObject queryStudentObjectByuserId(Integer userId) {
        return studentObjectMapper.queryStudentObjectByuserId(userId);
    }

    @Override
    public List<StudentObject> queryStudentObjectsByuserId(int userId) {
        return studentObjectMapper.queryStudentObjectsByuserId(userId);
    }
}
