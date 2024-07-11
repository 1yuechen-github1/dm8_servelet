package org.example.Service;

import org.example.Dto.ClassDto;
import org.example.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
     List<ClassRoom> getAllClassroom() ;

    List<ClassDto> queryByTeacherId(int teacherId);

    boolean delClassByClassId(int classId);

    
    ClassRoom queryByClassName(String name);

    int createClassRoom(String name, int teacherId);

    ClassRoom queryStudentById(int classesId);
}
