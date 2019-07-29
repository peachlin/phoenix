package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.ComplateRate;

public interface ComplateRateMapper {

  int deleteByPrimaryKey(String id);

  int insert(ComplateRate record);

  int insertSelective(ComplateRate record);

  ComplateRate selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(ComplateRate record);

  int updateByPrimaryKey(ComplateRate record);

  ComplateRate selectByDate(String dateStr);
}