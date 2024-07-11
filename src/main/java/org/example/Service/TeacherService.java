package org.example.Service;

import org.example.entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher queryTeacherByUserId(int id);

    Teacher queryTeacherByTeacherId(int createTeacher);

    int addTeacher(int userId);

    boolean delByUserId(int userId);

    List<Teacher> queryTeachersByUserId(int userId);
}
