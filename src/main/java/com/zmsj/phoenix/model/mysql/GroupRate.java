package com.zmsj.phoenix.model.mysql;

import java.util.Date;
import lombok.Data;

@Data
public class GroupRate {

  private String id;

  private String group;

  private Double rate;

  private Date date;
}