package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Teacher;

@Mapper
public interface TeacherMapper {

    public Teacher queryTeacherByUserId(int id) ;

    Teacher queryTeacherByTeacherId(int createTeacher);
}
