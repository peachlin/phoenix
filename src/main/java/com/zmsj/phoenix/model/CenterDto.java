package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
@ApiModel("中间区域数据模型")
public class CenterDto {

  @ApiModelProperty("生产人员数量")
  private int productionStaffNum;
  @ApiModelProperty("总产量")
  private int totalProduction;
  @ApiModelProperty("运行设备数")
  private int equipmentNum;
  @ApiModelProperty("生产环境质量")
  private int envQuality;
  @ApiModelProperty("设备详情")
  private List<Equipment> equipmentList;
}
