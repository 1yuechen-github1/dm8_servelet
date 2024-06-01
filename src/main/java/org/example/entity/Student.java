package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Student extends User{
    private int userId;
    private int studentId;
    private String classroom;



}
