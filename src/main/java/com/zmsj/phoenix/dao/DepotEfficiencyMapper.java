package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.DepotEfficiency;
import java.util.Date;

public interface DepotEfficiencyMapper {

  int deleteByPrimaryKey(String id);

  int insert(DepotEfficiency record);

  int insertSelective(DepotEfficiency record);

  DepotEfficiency selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(DepotEfficiency record);

  int updateByPrimaryKey(DepotEfficiency record);

  DepotEfficiency selectByDate(String dateStr);
}