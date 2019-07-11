package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.sqlserver.AlarmValues;

public interface AlarmValuesMapper {

  int insert(AlarmValues record);

  int insertSelective(AlarmValues record);
}