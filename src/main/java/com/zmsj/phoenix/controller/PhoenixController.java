package com.zmsj.phoenix.controller;

import com.zmsj.phoenix.model.CenterDto;
import com.zmsj.phoenix.model.FirstLeftDto;
import com.zmsj.phoenix.model.FirstRightDto;
import com.zmsj.phoenix.model.SecondLeftDto;
import com.zmsj.phoenix.model.SecondRightDto;
import com.zmsj.phoenix.service.PhoenixService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wang.kun
 */
@CrossOrigin
@Api(tags = "工业大屏接口")
@RestController
public class PhoenixController {

  @Resource
  private PhoenixService phoenixService;

  @GetMapping("/center")
  @ApiOperation("中间区域接口")
  public CenterDto getSummary() {

    return phoenixService.getSummary();
  }

  @GetMapping("/firstLeft")
  @ApiOperation("左边区域第一屏接口")
  public FirstLeftDto getFirstLeft() {

    return phoenixService.getFirstLeft();
  }

  @GetMapping("/secondLeft")
  @ApiOperation("左边区域第二屏接口")
  public SecondLeftDto getSecondLeft() {

    return phoenixService.getSecondLeft();
  }

  @GetMapping("/firstRight")
  @ApiOperation("右边区域第一屏接口")
  public FirstRightDto getFirstRight() {

    return phoenixService.getFirstRight();
  }

  @GetMapping("/secondRight")
  @ApiOperation("右边区域第二屏接口")
  public SecondRightDto getSecondRight() {

    return phoenixService.getSecondRight();
  }
}
