package com.zmsj.phoenix.model.mysql;

import java.util.Date;
import lombok.Data;

@Data
public class MaterialAnalysis {

  private Integer id;

  private String type;

  private Double rate;

  private Date date;
}