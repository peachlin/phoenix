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
  private int value;

  public KeyValueDto() {
  }

  public KeyValueDto(String key, int value) {
    this.key = key;
    this.value = value;
  }
}
