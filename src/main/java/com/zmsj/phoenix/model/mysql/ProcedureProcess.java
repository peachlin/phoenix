package com.zmsj.phoenix.model.mysql;

import lombok.Data;

@Data
public class ProcedureProcess {

  private String id;

  private String name;

  private Integer todayproductiontotal;

  private Double passrate;

  private Double goodrate;
}