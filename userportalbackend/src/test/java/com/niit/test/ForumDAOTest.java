package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

public class ForumDAOTest 
{

static ForumDAO forumDAO;

@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	
	forumDAO=(ForumDAO)context.getBean("forumDAO");
}
/*

@Test
public void addForum()
{
	Forum forum=new Forum();
	
	forum.setForumName("Java 8");
	forum.setForumContent("Java 8 Features");
	forum.setCreateDate(new java.util.Date());
	forum.setLikes(0);
	forum.setLoginname("lavanya");
	forum.setStatus("NA");
	
	assertTrue("Problem in Adding Forum",forumDAO.addForum(forum));
}
*/
@Test
public void approveForum()
{
	assertTrue("Problem in Approving Forum",forumDAO.approveForum(-46));
}



}