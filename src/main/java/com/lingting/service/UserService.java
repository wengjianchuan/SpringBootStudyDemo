package com.lingting.service;

import java.util.List;

import com.lingting.model.User;

public interface UserService {
	User selectByKey(Integer key);
	
	int insert(User user);
	
	List<User> selectAll(int pageNum, int pageSize);
	
}
