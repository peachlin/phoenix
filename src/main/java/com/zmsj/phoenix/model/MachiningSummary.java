package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("加工概览")
public class MachiningSummary {

  @ApiModelProperty("标题")
  private String title;
  @ApiModelProperty("产品编号")
  private String code;
  @ApiModelProperty("工序通过率指标")
  private List<KeyValueDto> summaryLisy;
}
