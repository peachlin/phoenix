package com.zmsj.phoenix.model.mysql;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Equipment {

  private String id;

  @ApiModelProperty("名称")
  private String name;
  @ApiModelProperty("设备状态")
  private String status;
  @ApiModelProperty("待机率")
  private double standbyRate;
  @ApiModelProperty("检验状态")
  private double testStatus;
  @ApiModelProperty("检验数量")
  private int testNum;
  @ApiModelProperty("合格率")
  private double passRate;
  @ApiModelProperty("任务完成率")
  private double taskCompleteRate;
}