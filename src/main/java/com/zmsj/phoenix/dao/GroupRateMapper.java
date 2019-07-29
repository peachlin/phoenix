package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.GroupRate;
import java.util.List;

public interface GroupRateMapper {

  int deleteByPrimaryKey(String id);

  int insert(GroupRate record);

  int insertSelective(GroupRate record);

  GroupRate selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(GroupRate record);

  int updateByPrimaryKey(GroupRate record);

  List<String> selectGroups();

  GroupRate selectByDateAndGroup(String dateStr, String group);
}