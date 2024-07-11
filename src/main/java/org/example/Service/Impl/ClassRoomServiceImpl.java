package org.example.Service.Impl;

import org.example.Dto.ClassDto;
import org.example.Mapper.ClassRoomMapper;
import org.example.Service.ClassRoomService;
import org.example.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Override
    public List<ClassRoom> getAllClassroom() {
        return classRoomMapper.getAllClassroom();
    }

    @Override
    public List<ClassDto> queryByTeacherId(int teacherId) {
        return classRoomMapper.queryByTeacherId(teacherId);
    }

    @Override
    public boolean delClassByClassId(int classId) {
        return classRoomMapper.delClassByClassId(classId);
    }

    @Override
    public ClassRoom queryByClassName(String name) {
        return classRoomMapper.queryByClassName(name);
    }

    @Override
    public int createClassRoom(String name, int teacherId) {
        return classRoomMapper.createClassRoom(name,teacherId);
    }

    @Override
    public ClassRoom queryStudentById(int classesId) {
        return classRoomMapper.queryStudentById(classesId);
    }

}
