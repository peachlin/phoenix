package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("日期-采购、消耗分析列表")
public class MaterialAnalysisDto {

  @ApiModelProperty("日期")
  private String date;
  @ApiModelProperty("采购、消耗-分析列表")
  private List<KeyValueDto> group2RateList;
}
