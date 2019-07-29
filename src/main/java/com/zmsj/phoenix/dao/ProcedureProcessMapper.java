package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.ProcedureProcess;
import java.util.List;

public interface ProcedureProcessMapper {

  int deleteByPrimaryKey(String id);

  int insert(ProcedureProcess record);

  int insertSelective(ProcedureProcess record);

  ProcedureProcess selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(ProcedureProcess record);

  int updateByPrimaryKey(ProcedureProcess record);

  List<ProcedureProcess> selectAll();
}