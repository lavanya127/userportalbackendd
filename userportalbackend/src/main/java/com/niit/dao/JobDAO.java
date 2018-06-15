package com.niit.dao;

import java.util.List;

import com.niit.model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> listAllJobs();
	public Job getJob(int jobId);
}
