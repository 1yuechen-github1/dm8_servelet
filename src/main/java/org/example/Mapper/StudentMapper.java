package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.common.R;
import org.example.entity.ClassRoom;
import org.example.entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student queryStudentByUserId(int id);

    int addStudent(int userId);

    List<Student> queryStudentByClassRoom(String clssRoom);


    ClassRoom queryStudentById(int classesId);
}
