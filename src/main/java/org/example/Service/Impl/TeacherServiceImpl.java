package org.example.Service.Impl;

import org.example.Mapper.TeacherMapper;
import org.example.Service.TeacherService;
import org.example.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
