package org.example.Service;

import org.example.entity.Teacher;

public interface TeacherService {
    Teacher queryTeacherByUserId(int id);

    Teacher queryTeacherByTeacherId(int createTeacher);
}
