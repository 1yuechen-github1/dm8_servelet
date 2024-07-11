package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.StudentObject;

import java.util.List;

@Mapper
public interface StudentObjectMapper {

    boolean delObjectAndStudebtBysubjectId(int subjectId);

    boolean delStudentCourseByCourseId(int userId,int courseId );

    List<StudentObject> queryAllStudentObject();

    boolean joinTheClass(int userId, int subjectId);

    StudentObject queryStudentObjectByuserId(Integer userId);

    List<StudentObject> queryStudentObjectsByuserId(int userId);
}
