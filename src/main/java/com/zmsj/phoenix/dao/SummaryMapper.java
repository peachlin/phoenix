package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.Summary;

public interface SummaryMapper {

  int deleteByPrimaryKey(String id);

  int insert(Summary record);

  int insertSelective(Summary record);

  Summary selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(Summary record);

  int updateByPrimaryKey(Summary record);

  Summary selectOne();
}