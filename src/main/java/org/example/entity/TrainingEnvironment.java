package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TrainingEnvironment {
    private int id;
    private String environmentName;
    private String environmentIntroduction;
    private String content;
    private String icon;
    private String creator;
}
