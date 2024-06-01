package org.example.Service.Impl;

import org.example.Mapper.StudentMapper;
import org.example.Service.StudentService;
import org.example.common.R;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public R<String> addStudent(Long courseId, List<Student> students) {
        return null;
    }

    @Override
    public Student queryStudentByUserId(int id) {
        return studentMapper.queryStudentByUserId(id);
    }
}
