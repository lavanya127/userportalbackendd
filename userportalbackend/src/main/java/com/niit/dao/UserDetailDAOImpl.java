package com.niit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;

@Repository("userDetailDAO")
public class UserDetailDAOImpl implements UserDetailDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean registerUser(UserDetail userDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Transactional
	public boolean checkCredential(UserDetail userDetail) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetail where loginname=:loginname and password=:passwd");
			query.setParameter("loginname", userDetail.getLoginname());
			query.setParameter("passwd", userDetail.getPassword());
			UserDetail userDetail1=(UserDetail)query.list().get(0);
			
			System.out.println(userDetail1.getUserName());
			
			if(userDetail1==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public UserDetail getUser(String loginname) 
	{
		Session session=sessionFactory.openSession();
		UserDetail userDetail=(UserDetail)session.get(UserDetail.class,loginname);
		return userDetail;
	}

}
