package org.example.Service;

import org.example.common.R;
import org.example.entity.Student;

import java.util.List;

public interface StudentService {

    R<String> addStudent(Long courseId, List<Student> students);

    Student queryStudentByUserId(int id);
}
