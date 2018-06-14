package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Blog;
import com.niit.model.BlogComment;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addBlog(Blog blog) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@Transactional
	public boolean deleteBlog(int blogId) 
	{
		try
		{
			Blog blog=(Blog)sessionFactory.getCurrentSession().get(Blog.class,blogId);
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	@Transactional
	public boolean updateBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public List<Blog> listApprovedBlogs() {
		try
		{
			Session session=sessionFactory.openSession(); //creating a session object
			Query query=session.createQuery("from Blog where status='A'"); //Creating a Query object
			List<Blog> listBlogs=query.list(); //calling list() method of query object which returns a list
			return listBlogs;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	@Transactional
	public boolean approveBlog(Blog blog) 
	{
		try
		{
			blog.setStatus("A"); //Specifying the status of the Blog as A which means Approved
			sessionFactory.getCurrentSession().update(blog); //updating the blog
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	@Transactional
	public boolean rejectBlog(Blog blog) 
	{
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog); //updating blog
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Blog getBlog(int blogId) {
		try
		{
			Session session=sessionFactory.openSession();
			Blog blog=(Blog)session.get(Blog.class, blogId);
			return blog;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Blog> listAllBlogs() 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Blog");
			List<Blog> listBlogs=query.list();
			return listBlogs;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	@Transactional
	public boolean incrementLike(Blog blog) {
		try
		{
			int likes=blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog); //updating the blog
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	@Transactional
	public boolean addBlogComment(BlogComment blogComment) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	public BlogComment getBlogComment(int commentId) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			BlogComment blogComment=(BlogComment)session.get(BlogComment.class,commentId);
			return blogComment;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public List<BlogComment> listBlogComments(int blogid) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogid");
		query.setParameter("blogid",new Integer(blogid));
		List<BlogComment> listBlogComments=query.list();
		System.out.println(listBlogComments.size());
		return listBlogComments;
	}

}
