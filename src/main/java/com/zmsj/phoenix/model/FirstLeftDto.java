package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("左侧第一屏数据模型")
public class FirstLeftDto {

  @ApiModelProperty("今日累计产量")
  private List<KeyValueDto> todayProductionTotal;
  @ApiModelProperty("工艺加工所用原料占比")
  private Map<String, Double> materialRatio;
  @ApiModelProperty("加工概览")
  private MachiningSummary machiningSummary;
}
