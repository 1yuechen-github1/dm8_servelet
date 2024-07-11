package org.example.Service;

import org.example.entity.ClassRoom;
import org.example.entity.Student;

import java.util.List;

public interface StudentService {

    int addStudent(int userId);

    Student queryStudentByUserId(int id);

    List<Student> queryStudentByClassRoom(String clssRoom);


    ClassRoom queryStudentById(int classesId);
}
