package com.zmsj.phoenix.model.mysql;

import java.util.Date;
import lombok.Data;

@Data
public class ComplateRate {

  private String id;

  private Double rate;

  private Date date;
}