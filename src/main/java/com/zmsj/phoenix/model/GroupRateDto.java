package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("日期-各组产品合格率列表")
public class GroupRateDto {

  @ApiModelProperty("日期")
  private String date;
  @ApiModelProperty("组-合格率列表")
  private List<KeyValueDto> group2RateList;
}
