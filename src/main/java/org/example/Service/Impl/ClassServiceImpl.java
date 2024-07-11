package org.example.Service.Impl;

import org.example.Mapper.ClassRoomMapper;
import org.example.Service.ClassService;
import org.example.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRoomMapper classRoomMapper;


}
