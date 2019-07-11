package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.sqlserver.Wertevar;

public interface WertevarMapper {

  int insert(Wertevar record);

  int insertSelective(Wertevar record);
}