package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("日期-不同类型能耗趋势")
public class EnergyConsumeDto {

  @ApiModelProperty("日期")
  private String date;
  @ApiModelProperty("气、水、电-分析列表")
  private List<KeyValueDto> group2RateList;
}
