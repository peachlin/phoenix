package com.zmsj.phoenix.model.mysql;

import java.util.Date;
import lombok.Data;

@Data
public class DepotEfficiency {

  private String id;

  private Date date;

  private Double rate;
}