package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {

    public Teacher queryTeacherByUserId(int id) ;

    Teacher queryTeacherByTeacherId(int createTeacher);

    int addTeacher(int userId);

    boolean delByUserId(int userId);

    List<Teacher> queryTeachersByUserId(int userId);
}
