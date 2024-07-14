package org.example.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.TeacherTrainingEnvironment;
import org.example.entity.TrainingEnvironment;

import java.util.List;

@Mapper
public interface TrainingEnvironmentMapper {

    List<TrainingEnvironment> getAllTrainingEnvironment();

    boolean insertIntoTrainingEnvironment(TrainingEnvironment trainingEnvironment);

    boolean delTrainingEnvironment(int id);

    boolean updateTrainingEnvironment(TrainingEnvironment trainingEnvironment);

    boolean createPracticalTraining(TeacherTrainingEnvironment trainingEnvironment);

    TrainingEnvironment getTrainingEnvironmentById(Integer environmentId);

    TeacherTrainingEnvironment getAllTeacherTrainingEnvironment(Integer courseId, Integer trainingId, String type);

    List<TeacherTrainingEnvironment> getAllTeacherTrainingEnvironments();

    boolean updateTeacherTrainingEnvironment(TeacherTrainingEnvironment trainingEnvironment);
}
