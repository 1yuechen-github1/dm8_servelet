package org.example.Service.Impl;


import org.example.Mapper.ObjectMapper;
import org.example.Service.ObjectService;
import org.example.common.R;
import org.example.entity.Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    private ObjectMapper objectMapper;

    public int createCourse(String name,String major){
     return objectMapper.createCourse(name,major);
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
}
