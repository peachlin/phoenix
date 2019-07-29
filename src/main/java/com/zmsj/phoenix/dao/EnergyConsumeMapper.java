package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.EnergyConsume;
import java.util.List;

public interface EnergyConsumeMapper {

  int deleteByPrimaryKey(String id);

  int insert(EnergyConsume record);

  int insertSelective(EnergyConsume record);

  EnergyConsume selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(EnergyConsume record);

  int updateByPrimaryKey(EnergyConsume record);

  List<String> selectTypes();

  EnergyConsume selectByDateAndType(String dateStr, String type);
}