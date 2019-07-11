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
@ApiModel("第一屏右侧区域数据模型")
public class FirstRightDto {

  @ApiModelProperty("质检指标-良品率")
  private Map<String, Double> goodRate;
  @ApiModelProperty("产品外观缺陷")
  private List<KeyValueDto> openDefect;
  @ApiModelProperty("出库效率")
  private List<KeyValueDto> depotEfficiency;
}
