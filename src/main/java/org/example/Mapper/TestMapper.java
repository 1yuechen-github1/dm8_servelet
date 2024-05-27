package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Exam;

import java.util.List;

@Mapper
public interface TestMapper {


    @Select("SELECT \"id\",\"name\",\"course_id\" AS \"courseId\",\"start_time\" AS \"startTime\",\"end_time\" AS \"endTime\" FROM \"dm8\".\"exams\"\n")
    List<Exam> selectAll();
}
