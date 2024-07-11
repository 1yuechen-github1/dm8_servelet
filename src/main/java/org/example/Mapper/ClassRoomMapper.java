package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.Dto.ClassDto;
import org.example.entity.ClassRoom;

import java.util.List;

@Mapper
public interface ClassRoomMapper {
    List<ClassDto> queryByTeacherId(int teacherId);

    boolean delClassByClassId(int classId);

    ClassRoom queryByClassName(String name);

    int createClassRoom(String name, int teacherId);

    List<ClassRoom> getAllClassroom();

    ClassRoom queryStudentById(int classesId);
}
