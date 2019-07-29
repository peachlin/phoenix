package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.ProblemStatistics;
import java.util.List;

public interface ProblemStatisticsMapper {

  int deleteByPrimaryKey(String id);

  int insert(ProblemStatistics record);

  int insertSelective(ProblemStatistics record);

  ProblemStatistics selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(ProblemStatistics record);

  int updateByPrimaryKey(ProblemStatistics record);

  List<ProblemStatistics> selectAll();
}