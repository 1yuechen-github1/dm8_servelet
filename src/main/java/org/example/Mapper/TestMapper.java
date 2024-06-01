package org.example.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Book;
import org.example.entity.Exam;
import org.example.entity.User;

import java.util.List;

@Mapper
public interface TestMapper {


    @Select("SELECT \"id\",\"name\",\"course_id\" AS \"courseId\",\"start_time\" AS \"startTime\",\"end_time\" AS \"endTime\" FROM \"dm8\".\"exams\"\n")
    List<Exam> selectAll();


    @Insert("INSERT INTO book (name, author, description) VALUES (#{name}, #{author}, #{description})")
    int insert(Book book);

    @Select("SELECT * FROM book WHERE id = #{id}")
    Book selectById(@Param("id") Integer id);


    User login(Object username, Object password);
}
