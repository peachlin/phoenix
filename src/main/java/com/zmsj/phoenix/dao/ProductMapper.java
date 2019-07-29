package com.zmsj.phoenix.dao;

import com.zmsj.phoenix.model.mysql.Product;

public interface ProductMapper {

  int deleteByPrimaryKey(String id);

  int insert(Product record);

  int insertSelective(Product record);

  Product selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(Product record);

  int updateByPrimaryKeyWithBLOBs(Product record);

  Product selectOne();
}