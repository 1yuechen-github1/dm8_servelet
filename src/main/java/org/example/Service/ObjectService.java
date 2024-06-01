package org.example.Service;

import org.example.common.R;
import org.example.entity.Object;

public interface ObjectService {

    public int createCourse(String name, String major);

    Object queryByObject(String courseName);

    int addStudent(int objectId, int userId);

    Object queryByObjectId(int courseId);
}
