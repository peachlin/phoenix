package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("第二屏右侧数据模型")
public class SecondRightDto {

  @ApiModelProperty("各组产品合格率")
  private List<GroupRateDto> groupRate;
  @ApiModelProperty("产品性能指标合格率")
  private List<KeyValueDto> perfQuality;
  @ApiModelProperty("封装常见问题处理统计")
  private List<KeyValueDto> problemStatistics;
}
