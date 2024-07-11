package org.example.Service;

import org.example.entity.StudentObject;

import java.util.List;

public interface StudentObjectService {
    boolean delObjectAndStudebtBysubjectId(int subjectId);

    boolean delStudentCourseByCourseId( int userId,int courseId);

    List<StudentObject> queryAllStudentObject();

    boolean joinTheClass(int userId, int subjectId);

    StudentObject queryStudentObjectByuserId(Integer userId);

    List<StudentObject> queryStudentObjectsByuserId(int userId);
}
