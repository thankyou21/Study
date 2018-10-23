package com.cg.tms.service;

import java.util.List;

import com.cg.tms.entities.Trainee;


public interface TraineeService 
{
	List<Trainee> getAllTrainees();
	void addTrainee(Trainee trainee);
	void deleteTrainee(int traineeId);
	Trainee retriveSingleTrainee(int trainee);
	void modifyTrainee(Trainee tdetails);
}
