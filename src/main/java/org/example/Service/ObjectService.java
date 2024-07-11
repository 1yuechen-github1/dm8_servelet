package org.example.Service;

import org.example.common.R;
import org.example.entity.ClassRoom;
import org.example.entity.ClassRoomObject;
import org.example.entity.Object;

import java.util.List;

public interface ObjectService {

    public int createCourse(String name, String major, String fileName1,int teacherId);

    Object queryByObject(String courseName);

    int addStudent(int objectId, int userId);

    Object queryByObjectId(int courseId);

    boolean delObjectBysubjectId(int subjectId);

    boolean updateSubject(Object object);

    List<Object> queryByObjectByTeacherId(int teacherId);

    List<Object> queryByObjectByTeacherIdAndClass(int teacherId ,String className);

    List<ClassRoomObject> queryClassBySubject(int subjectId);
}
