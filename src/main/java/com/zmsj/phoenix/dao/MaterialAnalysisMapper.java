package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.MaterialAnalysis;

public interface MaterialAnalysisMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(MaterialAnalysis record);

  int insertSelective(MaterialAnalysis record);

  MaterialAnalysis selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(MaterialAnalysis record);

  int updateByPrimaryKey(MaterialAnalysis record);

  MaterialAnalysis selectByDateAndType(String dateStr, String type);
}