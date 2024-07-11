package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.ClassRoomObject;
import org.example.entity.Object;

import java.util.List;

@Mapper
public interface ObjectMapper {
    int createCourse(String name,String major,String fileName1,int teacherId);

    Object queryByObject(String courseName);

    int addStudent(int objectId, int userId);

    Object queryByObjectId(int courseId);

    boolean delObjectBySubjectId(int subjectId);

    boolean updateSubject(Object object);

    List<Object> queryByObjectByTeacherId(int teacherId);

    List<Object> queryByObjectByTeacherIdAndClass(int teacherId, String className);

    List<ClassRoomObject> queryClassRoomIdBySubjectId(int subjectId);
}
