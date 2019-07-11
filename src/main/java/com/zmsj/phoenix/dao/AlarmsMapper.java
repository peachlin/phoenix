package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.sqlserver.Alarms;

public interface AlarmsMapper {

  int insert(Alarms record);

  int insertSelective(Alarms record);
}