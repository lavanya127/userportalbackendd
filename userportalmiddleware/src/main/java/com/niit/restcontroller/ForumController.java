package com.niit.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.ForumDAO;
import com.niit.model.Forum;

@RestController
public class ForumController 
{

	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping(value="/listForum")
	public ResponseEntity<List<Forum>> getForumList()
	{
		
		List<Forum> listForums=forumDAO.listAllForums();
		
		if(listForums.size()>0)
		{
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=forumDAO.getForum(forumId);
		
		if(forumDAO.deleteForum(forum))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error Occured",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setLikes(0);
		forum.setLoginname("dolly");
		forum.setStatus("NA");
		
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error Occured",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/approveForum/{forumId}")
	public ResponseEntity<String> approveForum(@PathVariable("forumId")int forumId)
	{
		if(forumDAO.approveForum(forumId))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error Occured",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/rejectForum/{forumId}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumId")int forumId)
	{
		if(forumDAO.rejectForum(forumId))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error Occured",HttpStatus.NOT_FOUND);
		}
	}
	
}


