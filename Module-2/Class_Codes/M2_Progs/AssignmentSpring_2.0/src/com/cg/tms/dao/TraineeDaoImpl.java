package com.cg.tms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.tms.entities.Trainee;

@Repository
public class TraineeDaoImpl implements TraineeDao
{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Trainee> getAllTrainees() 
	{
		String jpql = "SELECT t FROM Trainee t";
		TypedQuery<Trainee> query = em.createQuery(jpql, Trainee.class);
		return query.getResultList();
	}

	@Override
	public void addTrainee(Trainee trainee) 
	{
		em.persist(trainee);
	}

	@Override
	public void deleteTrainee(int traineeId) 
	{
		Trainee removeTrainee = em.find(Trainee.class,traineeId);
		em.remove(removeTrainee);
	}

	@Override
	public Trainee retriveSingleTrainee(int traineeId) 
	{
		Trainee findTrainee = em.find(Trainee.class,traineeId);
		return findTrainee;
	}

	@Override
	public void modifyTrainee(Trainee tdetails) 
	{
		em.merge(tdetails);
	}

}
