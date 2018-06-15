package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

public class UserDetailDAOTestCase 
{
	static UserDetailDAO userDetailDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		userDetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
	}
	/*

	@Test
	public void registerUserTest()
	{
		UserDetail userDetail=new UserDetail();
		
		userDetail.setLoginname("lavanya");
		userDetail.setPassword("lavanya");
		userDetail.setUserName("lavanya");
		userDetail.setEmailId("lavanya@gmail.com");
		userDetail.setAddress("VJA");
		userDetail.setMobileNo("9490195732");
		userDetail.setRole("ROLE_ADMIN");
		
		assertTrue("Problem in Registering User",userDetailDAO.registerUser(userDetail));
	}
	
	@Test
	public void checkUserTest()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setLoginname("lavanya");
		userDetail.setPassword("lavanya");
		
		assertTrue("Problem in Login Process:",userDetailDAO.checkCredential(userDetail));
		
	}
	*/
	@Test 
	public void getUserTest()
	{
		assertNotNull("Problem in Accessing a User",userDetailDAO.getUser("lavanya"));
	}
	
}

