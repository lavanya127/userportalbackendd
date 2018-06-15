package com.niit.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.UserDetailDAO;
import com.niit.model.UserDetail;

@RestController
public class UserController 
{
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@PostMapping(value="/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody UserDetail userDetail)
	{
		
		if(userDetailDAO.registerUser(userDetail))
		{
			return new ResponseEntity<String>("Successfully Registered",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Registering",HttpStatus.UNAUTHORIZED);
		}
	}
	/*
	@PostMapping(value="/checkLogin")
	public ResponseEntity<UserDetail> checkLogin(@RequestBody UserDetail userDetail,HttpSession session)
	{
		if(userDetailDAO.checkCredential(userDetail))
		{
			UserDetail tempUser=userDetailDAO.getUser(userDetail.getLoginname());
			session.setAttribute("userDetail", tempUser);
			return new ResponseEntity<UserDetail>(tempUser,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail,HttpStatus.UNAUTHORIZED);
		}
	}
	
}
*/
}
