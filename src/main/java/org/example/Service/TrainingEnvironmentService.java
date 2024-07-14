package org.example.Service;

import org.example.entity.TeacherTrainingEnvironment;
import org.example.entity.TrainingEnvironment;

import java.util.List;

public interface TrainingEnvironmentService {


    List<TrainingEnvironment> getAllTrainingEnvironment();

    TrainingEnvironment getTrainingEnvironmentById(Integer environmentId);

    boolean updateTrainingEnvironment(TrainingEnvironment trainingEnvironment);

    boolean insertIntoTrainingEnvironment(TrainingEnvironment trainingEnvironment);

    boolean delTrainingEnvironment(int id);

    boolean createPracticalTraining(TeacherTrainingEnvironment trainingEnvironment);

    TeacherTrainingEnvironment getAllTeacherTrainingEnvironment(Integer courseId, Integer trainingId, String type);

    List<TeacherTrainingEnvironment> getAllTeacherTrainingEnvironments();

    boolean updateTeacherTrainingEnvironment(TeacherTrainingEnvironment trainingEnvironment);
}
