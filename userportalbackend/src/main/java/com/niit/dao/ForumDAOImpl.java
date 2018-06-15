package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Forum;

@Repository("forumDAO")
@Transactional 
public class ForumDAOImpl implements ForumDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addForum(Forum forum) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	public boolean deleteForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().delete(forum);
		return true;
		}
		catch(Exception e)
		{
		return false;	
		}
	}

	public List<Forum> listApprovedForums() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum where status='A'");
		List<Forum> listForums=query.list();
		return listForums;
	}

	public List<Forum> listAllForums() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> listForums=query.list();
		return listForums;
	}

	public boolean approveForum(int forumId) 
	{
		try
		{
		Session session=sessionFactory.getCurrentSession();
		Forum forum=this.getForum(forumId);
		forum.setStatus("A");
		session.update(forum);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean rejectForum(int forumId) {
		try
		{
		Session session=sessionFactory.getCurrentSession();
		Forum forum=this.getForum(forumId);
		forum.setStatus("NA");
		session.update(forum);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Forum getForum(int forumId) 
	{
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,forumId);
		session.close();
		return forum;
	}

}
