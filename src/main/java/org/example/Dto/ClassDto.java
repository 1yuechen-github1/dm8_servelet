package org.example.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.ClassRoom;
import org.example.entity.Object;

import java.util.List;


@Data
@Getter
@Setter
public class ClassDto extends ClassRoom {
    private int sum;
    private List<Object> subjectName;
}
