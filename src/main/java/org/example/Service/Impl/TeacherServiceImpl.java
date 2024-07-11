package org.example.Service.Impl;

import org.example.Mapper.TeacherMapper;
import org.example.Service.TeacherService;
import org.example.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public Teacher queryTeacherByUserId(int id) {
        return teacherMapper.queryTeacherByUserId(id);
    }

    @Override
    public Teacher queryTeacherByTeacherId(int createTeacher) {
        return teacherMapper.queryTeacherByTeacherId(createTeacher);
    }

    @Override
    public int addTeacher(int userId) {
        return teacherMapper.addTeacher(userId);
    }

    @Override
    public boolean delByUserId(int userId) {
        return teacherMapper.delByUserId(userId);
    }

    @Override
    public List<Teacher> queryTeachersByUserId(int userId) {
        return teacherMapper.queryTeachersByUserId(userId);
    }
}
