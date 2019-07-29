package com.zmsj.phoenix.service;

import com.google.common.collect.Lists;
import com.zmsj.phoenix.model.CenterDto;
import com.zmsj.phoenix.model.EnergyConsumeDto;
import com.zmsj.phoenix.model.FirstLeftDto;
import com.zmsj.phoenix.model.FirstRightDto;
import com.zmsj.phoenix.model.GroupRateDto;
import com.zmsj.phoenix.model.KeyValueDto;
import com.zmsj.phoenix.model.MachiningSummary;
import com.zmsj.phoenix.model.MaterialAnalysisDto;
import com.zmsj.phoenix.model.SecondLeftDto;
import com.zmsj.phoenix.model.SecondRightDto;
import com.zmsj.phoenix.model.mysql.Equipment;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 * @author wang.kun
 */
@Service
public class PhoenixService_bak {

  public CenterDto getSummary() {

    CenterDto centerDto = new CenterDto();
    centerDto.setProductionStaffNum(getRandom(79, 74));
    centerDto.setTotalProduction(getRandom(6854, 5678));
    centerDto.setEquipmentNum(getRandom(146, 144));
    centerDto.setEnvQuality(getRandom(100, 89));

    List<Equipment> equipmentList = Lists.newArrayList();
    for (int i = 0; i < 4; i++) {
      Equipment equipment = new Equipment();
      equipment.setName("设备" + (i + 1));
      equipment.setStatus("正常");
      equipment.setStandbyRate(getRandom(100, 87));
      equipment.setTestStatus(getRandom(100, 87));
      equipment.setTestNum(getRandom(378, 312));
      equipment.setPassRate(getRandom(100, 87));
      equipment.setTaskCompleteRate(getRandom(100, 65));
      equipmentList.add(equipment);
    }
    centerDto.setEquipmentList(equipmentList);
    return centerDto;
  }

  public FirstLeftDto getFirstLeft() {

    FirstLeftDto firstLeftDto = new FirstLeftDto();
    KeyValueDto kv1 = new KeyValueDto("工序A", (double) getRandom(2898, 1765));
    KeyValueDto kv2 = new KeyValueDto("工序B", (double) getRandom(2898, 1765));
    KeyValueDto kv3 = new KeyValueDto("工序C", (double) getRandom(2898, 1765));
    KeyValueDto kv4 = new KeyValueDto("工序D", (double) getRandom(2898, 1765));
    KeyValueDto kv5 = new KeyValueDto("工序E", (double) getRandom(2898, 1765));
    List<KeyValueDto> list1 = Lists.newArrayList(kv1, kv2, kv3, kv4, kv5);
    firstLeftDto.setTodayProductionTotal(list1);

    MachiningSummary summary = new MachiningSummary();
    summary.setTitle("正在加工:移动设备屏幕-彩屏");
    summary.setCode("ZJY0980");
    KeyValueDto kv7 = new KeyValueDto("工序A通过率", getRandom(100, 92));
    KeyValueDto kv8 = new KeyValueDto("工序B通过率", getRandom(100, 92));
    KeyValueDto kv9 = new KeyValueDto("工序C通过率", getRandom(100, 92));
    KeyValueDto kv10 = new KeyValueDto("工序D通过率", getRandom(100, 92));
    KeyValueDto kv11 = new KeyValueDto("工序E通过率", getRandom(100, 92));
    List<KeyValueDto> list2 = Lists.newArrayList(kv7, kv8, kv9, kv10, kv11);
    summary.setSummaryList(list2);
    firstLeftDto.setMachiningSummary(summary);

    Map<String, Double> ratio = new HashMap<>();
    ratio.put("原料1", 35d);
    ratio.put("原料2", 12d);
    ratio.put("原料3", 8d);
    ratio.put("原料4", 45d);
    firstLeftDto.setMaterialRatio(ratio);

    return firstLeftDto;
  }

  public SecondLeftDto getSecondLeft() {

    SecondLeftDto secondLeftDto = new SecondLeftDto();
    List<MaterialAnalysisDto> list1 = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      MaterialAnalysisDto dto = new MaterialAnalysisDto();
      dto.setDate(getDate(4 - i));
      KeyValueDto a = new KeyValueDto("采购", (double) getRandom(7000, 6000));
      KeyValueDto b = new KeyValueDto("消耗", (double) getRandom(7000, 6000));
      dto.setGroup2RateList(Lists.newArrayList(a, b));
      list1.add(dto);
    }
    secondLeftDto.setMaterialAnalysis(list1);

    List<KeyValueDto> list2 = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      KeyValueDto kv = new KeyValueDto(getDate(4 - i), getRandom(100, 62));
      list2.add(kv);
    }
    secondLeftDto.setCompletionRate(list2);

    List<EnergyConsumeDto> list3 = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      EnergyConsumeDto dto = new EnergyConsumeDto();
      dto.setDate(getDate(4 - i));

      KeyValueDto a = new KeyValueDto("气", getRandom(100, 87));
      KeyValueDto b = new KeyValueDto("水", getRandom(100, 87));
      KeyValueDto c = new KeyValueDto("电", getRandom(100, 87));
      dto.setGroup2RateList(Lists.newArrayList(a, b, c));
      list3.add(dto);
    }
    secondLeftDto.setEnergyConsume(list3);
    return secondLeftDto;
  }

  public FirstRightDto getFirstRight() {

    FirstRightDto firstRightDto = new FirstRightDto();

    List<KeyValueDto> list1 = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      KeyValueDto kv = new KeyValueDto(getDate(4 - i), getRandom(100, 79));
      list1.add(kv);
    }
    firstRightDto.setDepotEfficiency(list1);

    Map<String, Double> goodRate = new HashMap<>();
    goodRate.put("工序A通过率", 0.97);
    goodRate.put("工序B通过率", 0.99);
    goodRate.put("工序C通过率", 1.0);
    goodRate.put("工序D通过率", 0.98);
    goodRate.put("工序E通过率", 0.98);
    firstRightDto.setGoodRate(goodRate);

    KeyValueDto kv7 = new KeyValueDto("缺陷1", 0.07);
    KeyValueDto kv8 = new KeyValueDto("缺陷2", 0.08);
    KeyValueDto kv9 = new KeyValueDto("缺陷3", 0.01);
    KeyValueDto kv10 = new KeyValueDto("缺陷4", 0.13);
    List<KeyValueDto> list2 = Lists.newArrayList(kv7, kv8, kv9, kv10);
    firstRightDto.setOpenDefect(list2);
    return firstRightDto;
  }

  public SecondRightDto getSecondRight() {

    SecondRightDto secondRightDto = new SecondRightDto();

    List<GroupRateDto> list1 = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      GroupRateDto groupRateDto = new GroupRateDto();
      groupRateDto.setDate(getDate(4 - i));

      KeyValueDto a = new KeyValueDto("一组", getRandom(100, 95));
      KeyValueDto b = new KeyValueDto("二组", getRandom(100, 95));
      KeyValueDto c = new KeyValueDto("三组", getRandom(100, 95));
      groupRateDto.setGroup2RateList(Lists.newArrayList(a, b, c));
      list1.add(groupRateDto);
    }
    secondRightDto.setGroupRate(list1);

    KeyValueDto dto1 = new KeyValueDto("指标1", getRandom(100, 95));
    KeyValueDto dto2 = new KeyValueDto("指标2", getRandom(95, 90));
    KeyValueDto dto3 = new KeyValueDto("指标3", getRandom(90, 85));
    KeyValueDto dto4 = new KeyValueDto("指标4", getRandom(85, 80));
    secondRightDto.setPerfQuality(Lists.newArrayList(dto1, dto2, dto3, dto4));

    KeyValueDto dto5 = new KeyValueDto("问题1", getRandom(12, 4));
    KeyValueDto dto6 = new KeyValueDto("问题2", getRandom(12, 4));
    KeyValueDto dto7 = new KeyValueDto("问题3", getRandom(12, 4));
    KeyValueDto dto8 = new KeyValueDto("问题4", getRandom(12, 4));
    secondRightDto.setProblemStatistics(Lists.newArrayList(dto5, dto6, dto7, dto8));
    return secondRightDto;
  }

  private int getRandom(int max, int min) {

    return new Random().nextInt(max - min) + min;
  }

  private String getDate(int i) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - i);
    return (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.DAY_OF_MONTH);
  }
}
