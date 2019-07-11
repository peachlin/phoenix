package com.zmsj.phoenix.controller;

import com.zmsj.phoenix.model.CenterDto;
import com.zmsj.phoenix.model.FirstLeftDto;
import com.zmsj.phoenix.model.FirstRightDto;
import com.zmsj.phoenix.model.SecondLeftDto;
import com.zmsj.phoenix.model.SecondRightDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang.kun
 */
@Api(tags = "工业大屏接口")
@RestController
public class PhoenixController {

  @GetMapping("/center")
  @ApiOperation("中间区域接口")
  public CenterDto getSummary() {
    return null;
  }

  @GetMapping("/firstLeft")
  @ApiOperation("左边区域第一屏接口")
  public FirstLeftDto getFirstLeft() {
    return null;
  }

  @GetMapping("/secondLeft")
  @ApiOperation("左边区域第二屏接口")
  public SecondLeftDto getSecondLeft() {
    return null;
  }

  @GetMapping("/firstRight")
  @ApiOperation("右边区域第一屏接口")
  public FirstRightDto getFirstRight() {

    return null;
  }

  @GetMapping("/secondRight")
  @ApiOperation("右边区域第二屏接口")
  public SecondRightDto getSecondRight() {
    return null;
  }
}
