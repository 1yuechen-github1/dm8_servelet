package org.example.Service.Impl;

import org.example.Mapper.TrainingEnvironmentMapper;
import org.example.Service.TrainingEnvironmentService;
import org.example.entity.TeacherTrainingEnvironment;
import org.example.entity.TrainingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingEnvironmentServiceImpl implements TrainingEnvironmentService {

    @Autowired
    private TrainingEnvironmentMapper trainingEnvironmentMapper;

    @Override
    public List<TrainingEnvironment> getAllTrainingEnvironment() {
        List<TrainingEnvironment> allTrainingEnvironment = trainingEnvironmentMapper.getAllTrainingEnvironment();
        return allTrainingEnvironment;
    }

    @Override
    public TrainingEnvironment getTrainingEnvironmentById(Integer environmentId) {
        return trainingEnvironmentMapper.getTrainingEnvironmentById(environmentId);
    }

    @Override
    public boolean updateTrainingEnvironment(TrainingEnvironment trainingEnvironment) {
        return trainingEnvironmentMapper.updateTrainingEnvironment(trainingEnvironment);
    }

    @Override
    public boolean insertIntoTrainingEnvironment(TrainingEnvironment trainingEnvironment) {
        return trainingEnvironmentMapper.insertIntoTrainingEnvironment(trainingEnvironment);
    }

    @Override
    public boolean delTrainingEnvironment(int id) {
        return trainingEnvironmentMapper.delTrainingEnvironment(id);
    }

    @Override
    public boolean createPracticalTraining(TeacherTrainingEnvironment trainingEnvironment) {
        return trainingEnvironmentMapper.createPracticalTraining(trainingEnvironment);
    }

    @Override
    public TeacherTrainingEnvironment getAllTeacherTrainingEnvironment(Integer courseId, Integer trainingId, String type) {
        return trainingEnvironmentMapper.getAllTeacherTrainingEnvironment( courseId,  trainingId,  type);
    }

    @Override
    public List<TeacherTrainingEnvironment> getAllTeacherTrainingEnvironments() {
        return trainingEnvironmentMapper.getAllTeacherTrainingEnvironments();
    }

    @Override
    public boolean updateTeacherTrainingEnvironment(TeacherTrainingEnvironment trainingEnvironment) {
        return trainingEnvironmentMapper.updateTeacherTrainingEnvironment(trainingEnvironment);
    }
}
