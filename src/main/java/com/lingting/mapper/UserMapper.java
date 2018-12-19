package com.lingting.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lingting.base.MapperBase;
import com.lingting.model.User;

@Mapper
public interface UserMapper extends MapperBase<User> {
}
