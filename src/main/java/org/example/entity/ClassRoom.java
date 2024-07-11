package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClassRoom {
    private int id;
    private String className;
    private int teacherId;

}
