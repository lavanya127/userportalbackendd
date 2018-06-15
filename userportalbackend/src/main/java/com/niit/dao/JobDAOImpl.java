package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Job;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional 
	public boolean addJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean updateJob(Job job) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Job> listAllJobs() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> listJobs=query.list();
		return listJobs;
	}

	public Job getJob(int jobId) 
	{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		return job;
	}
	
}
