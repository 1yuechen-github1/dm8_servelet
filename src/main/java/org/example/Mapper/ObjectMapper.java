package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Object;

@Mapper
public interface ObjectMapper {
    int createCourse(String name,String major);

    Object queryByObject(String courseName);

    int addStudent(int objectId, int userId);

    Object queryByObjectId(int courseId);
}
