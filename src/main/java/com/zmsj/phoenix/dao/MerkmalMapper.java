package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.sqlserver.Merkmal;

public interface MerkmalMapper {

  int insert(Merkmal record);

  int insertSelective(Merkmal record);
}