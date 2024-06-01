package org.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Teacher extends User{

    private int userId;
    private int teacherId;
    private int subjectId;

}
