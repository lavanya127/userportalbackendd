package com.niit.dao;

import com.niit.model.UserDetail;

public interface UserDetailDAO 
{
	public boolean registerUser(UserDetail userDetail);
	public boolean checkCredential(UserDetail userDetail);
	public UserDetail getUser(String loginname);

}
