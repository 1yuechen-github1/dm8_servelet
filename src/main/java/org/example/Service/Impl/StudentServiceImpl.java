package org.example.Service.Impl;

import org.example.Mapper.StudentMapper;
import org.example.Service.StudentService;
import org.example.entity.ClassRoom;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;


    @Override
    public int addStudent(int userId) {
        return studentMapper.addStudent(userId);
    }

    @Override
    public Student queryStudentByUserId(int id) {
        return studentMapper.queryStudentByUserId(id);
    }

    @Override
    public List<Student> queryStudentByClassRoom(String clssRoom) {
        return studentMapper.queryStudentByClassRoom(clssRoom);
    }

    @Override
    public ClassRoom queryStudentById(int classesId) {
        return studentMapper.queryStudentById(classesId);
    }


}
