package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.Equipment;
import java.util.List;

public interface EquipmentMapper {

  int deleteByPrimaryKey(String id);

  int insert(Equipment record);

  int insertSelective(Equipment record);

  Equipment selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(Equipment record);

  int updateByPrimaryKey(Equipment record);

  List<Equipment> selectN(int num);
}