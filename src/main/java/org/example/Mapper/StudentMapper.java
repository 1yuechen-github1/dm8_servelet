package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Student;

@Mapper
public interface StudentMapper {
    Student queryStudentByUserId(int id);
}
