package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("第二屏左侧数据模型")
public class SecondLeftDto {

  @ApiModelProperty("能耗趋势")
  private List<EnergyConsumeDto> energyConsume;
  @ApiModelProperty("原料分析")
  private List<MaterialAnalysisDto> materialAnalysis;
  @ApiModelProperty("产品实际完成率")
  private List<KeyValueDto> completionRate;
}
