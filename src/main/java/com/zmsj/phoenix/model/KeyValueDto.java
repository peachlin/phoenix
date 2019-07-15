package com.zmsj.phoenix.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wang.kun
 */
@Data
public class KeyValueDto {

  @ApiModelProperty("key")
  private String key;
  @ApiModelProperty("value")
  private Double value;

  public KeyValueDto() {
  }

  public KeyValueDto(String key, Double value) {
    this.key = key;
    this.value = value;
  }
}
