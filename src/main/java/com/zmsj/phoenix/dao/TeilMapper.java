package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.sqlserver.TeilWithBLOBs;

public interface TeilMapper {

  int insert(TeilWithBLOBs record);

  int insertSelective(TeilWithBLOBs record);
}