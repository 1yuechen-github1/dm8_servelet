package org.example.Service.Impl;


import org.example.Mapper.ObjectMapper;
import org.example.Service.ObjectService;
import org.example.common.R;
import org.example.entity.ClassRoom;
import org.example.entity.ClassRoomObject;
import org.example.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectMapper objectMapper;

    public int createCourse(String name,String major, String fileName1,int teacherId){
     return objectMapper.createCourse(name,major,fileName1,teacherId);
    }

    @Override
    public Object queryByObject(String courseName) {
        return objectMapper.queryByObject(courseName);
    }

    @Override
    public int addStudent(int objectId, int userId) {
        return  objectMapper.addStudent(objectId, userId);
    }

    @Override
    public Object queryByObjectId(int courseId) {
        return objectMapper.queryByObjectId(courseId);
    }

    @Override
    public boolean delObjectBysubjectId(int subjectId) {
        return objectMapper.delObjectBySubjectId(subjectId);
    }

    @Override
    public boolean updateSubject(Object object) {
        return objectMapper.updateSubject(object);
    }

    @Override
    public List<Object> queryByObjectByTeacherId(int teacherId) {
        return objectMapper.queryByObjectByTeacherId(teacherId);
    }

    @Override
    public List<Object> queryByObjectByTeacherIdAndClass(int teacherId,String className) {
        return objectMapper.queryByObjectByTeacherIdAndClass( teacherId, className);
    }

    @Override
    public List<ClassRoomObject> queryClassBySubject(int subjectId) {
         List<ClassRoomObject> list = objectMapper.queryClassRoomIdBySubjectId(subjectId);
        return list;
    }
}
