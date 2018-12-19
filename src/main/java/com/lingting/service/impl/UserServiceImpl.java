package com.lingting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.lingting.db.annotation.DataSource;
import com.lingting.mapper.UserMapper;
import com.lingting.model.User;
import com.lingting.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@DataSource(value = "ds1")
	@Transactional
	@Override
	public User selectByKey(Integer key) {
		return userMapper.selectByPrimaryKey(key);
	}
	
	@DataSource
	@Transactional
	@Override
	public int insert(User user) {
		return userMapper.insert(user);
	}
	
	@DataSource(value = "ds1")
	@Transactional
	@Override
	public List<User> selectAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.selectAll();
	}
}
