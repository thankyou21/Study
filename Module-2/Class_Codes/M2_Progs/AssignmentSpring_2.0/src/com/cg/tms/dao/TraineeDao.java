package com.cg.tms.dao;

import java.util.List;

import com.cg.tms.entities.Trainee;


public interface TraineeDao 
{
	List<Trainee> getAllTrainees();
	void addTrainee(Trainee trainee);
	void deleteTrainee(int traineeId);
	Trainee retriveSingleTrainee(int traineeId);
	void modifyTrainee( Trainee tdetails);
}
