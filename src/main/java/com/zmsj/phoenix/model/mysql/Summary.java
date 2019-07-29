package com.zmsj.phoenix.model.mysql;

import lombok.Data;

@Data
public class Summary {

  private String id;

  private Integer productionstaffnum;

  private Integer totalproduction;

  private Integer equipmentnum;

  private Integer envquality;

  private String product;

  private String productcode;
}