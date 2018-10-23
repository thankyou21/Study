package com.cg.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.dao.TraineeDao;
import com.cg.tms.entities.Trainee;

@Service
@Transactional
public class TraineeServiceImpl implements TraineeService
{
	@Autowired
	TraineeDao tDao;
	
	@Override
	public List<Trainee> getAllTrainees() 
	{
		return tDao.getAllTrainees();
	}

	@Override
	public void addTrainee(Trainee trainee) 
	{
		tDao.addTrainee(trainee);
	}

	@Override
	public void deleteTrainee(int traineeId) {
		tDao.deleteTrainee(traineeId);
		
	}

	@Override
	public Trainee retriveSingleTrainee(int trainee) 
	{
		return tDao.retriveSingleTrainee(trainee);
	}

	@Override
	public void modifyTrainee(Trainee tdetails) 
	{
		tDao.modifyTrainee(tdetails);
	}
	
}
