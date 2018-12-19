package com.lingting.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MapperBase<T> extends Mapper<T>, MySqlMapper<T> {

}
