package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="jobidseq",sequenceName="jobid_seq")
public class Job 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobidseq")
	int jobId;
	
	String jobDesignation;
	String company;
	int salary;
	String location;
	String jobDesc;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date lastDateApply;
	
	
	public int getJobId() 
	{
		return jobId;
	}
	public void setJobId(int jobId) 
	{
		this.jobId = jobId;
	}
	public String getJobDesignation() 
	{
		return jobDesignation;
	}
	public void setJobDesignation(String jobDesignation) 
	{
		this.jobDesignation = jobDesignation;
	}
	public String getCompany() 
	{
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public Date getLastDateApply() {
		return lastDateApply;
	}
	public void setLastDateApply(Date lastDateApply) {
		this.lastDateApply = lastDateApply;
	}
	
	
	

}
