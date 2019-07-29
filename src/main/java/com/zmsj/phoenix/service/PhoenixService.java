package com.zmsj.phoenix.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zmsj.phoenix.dao.ComplateRateMapper;
import com.zmsj.phoenix.dao.DepotEfficiencyMapper;
import com.zmsj.phoenix.dao.EnergyConsumeMapper;
import com.zmsj.phoenix.dao.EquipmentMapper;
import com.zmsj.phoenix.dao.GroupRateMapper;
import com.zmsj.phoenix.dao.MaterialAnalysisMapper;
import com.zmsj.phoenix.dao.ProblemStatisticsMapper;
import com.zmsj.phoenix.dao.ProcedureProcessMapper;
import com.zmsj.phoenix.dao.ProductMapper;
import com.zmsj.phoenix.dao.SummaryMapper;
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
import com.zmsj.phoenix.model.mysql.ComplateRate;
import com.zmsj.phoenix.model.mysql.DepotEfficiency;
import com.zmsj.phoenix.model.mysql.EnergyConsume;
import com.zmsj.phoenix.model.mysql.GroupRate;
import com.zmsj.phoenix.model.mysql.MaterialAnalysis;
import com.zmsj.phoenix.model.mysql.ProblemStatistics;
import com.zmsj.phoenix.model.mysql.ProcedureProcess;
import com.zmsj.phoenix.model.mysql.Product;
import com.zmsj.phoenix.model.mysql.Summary;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author wang.kun
 */
@Service
public class PhoenixService {

  @Resource
  private SummaryMapper summaryMapper;

  @Resource
  private EquipmentMapper equipmentMapper;

  @Resource
  private ProcedureProcessMapper procedureProcessMapper;

  @Resource
  private ProductMapper productMapper;

  @Resource
  private DepotEfficiencyMapper depotEfficiencyMapper;

  @Resource
  private ComplateRateMapper complateRateMapper;

  @Resource
  private MaterialAnalysisMapper materialAnalysisMapper;

  @Resource
  private EnergyConsumeMapper energyConsumeMapper;

  @Resource
  private ProblemStatisticsMapper problemStatisticsMapper;

  @Resource
  private GroupRateMapper groupRateMapper;

  public CenterDto getSummary() {

    CenterDto centerDto = new CenterDto();

    Summary summary = summaryMapper.selectOne();
    if (null != summary) {
      centerDto.setProductionStaffNum(summary.getProductionstaffnum());
      centerDto.setTotalProduction(summary.getTotalproduction());
      centerDto.setEquipmentNum(summary.getEquipmentnum());
      centerDto.setEnvQuality(summary.getEnvquality());
    }

    centerDto.setEquipmentList(equipmentMapper.selectN(4));
    return centerDto;
  }

  public FirstLeftDto getFirstLeft() {

    FirstLeftDto firstLeftDto = new FirstLeftDto();

    List<ProcedureProcess> processList = procedureProcessMapper.selectAll();

    List<KeyValueDto> todayProductionTotal = Lists.newArrayList();
    List<KeyValueDto> summaryList = Lists.newArrayList();
    for (ProcedureProcess p : processList) {
      KeyValueDto kv1 = new KeyValueDto(p.getName(), p.getTodayproductiontotal());
      KeyValueDto kv2 = new KeyValueDto(p.getName() + "通过率", p.getPassrate());
      todayProductionTotal.add(kv1);
      summaryList.add(kv2);
    }
    firstLeftDto.setTodayProductionTotal(todayProductionTotal);

    Summary summary = summaryMapper.selectOne();
    MachiningSummary machiningSummary = new MachiningSummary();
    if (null != summary) {
      machiningSummary.setTitle(summary.getProduct());
      machiningSummary.setCode(summary.getProductcode());
    }
    machiningSummary.setSummaryList(summaryList);
    firstLeftDto.setMachiningSummary(machiningSummary);

    Product product = productMapper.selectOne();
    Map<String, Double> ratio = null;
    if (null != product && null != product.getMaterialRatio()) {
      ratio = new Gson().fromJson(product.getMaterialRatio(), new TypeToken<Map<String, Double>>() {
      }.getType());
    }

    firstLeftDto.setMaterialRatio(ratio);

    return firstLeftDto;
  }

  public SecondLeftDto getSecondLeft() {

    SecondLeftDto secondLeftDto = new SecondLeftDto();
    List<String> types = energyConsumeMapper.selectTypes();

    List<EnergyConsumeDto> energyConsume = Lists.newArrayList();
    for (int i = 0; i < 7; i++) {
      EnergyConsumeDto dto = new EnergyConsumeDto();

      String dateStr = getDateStr(6 - i);
      dto.setDate(dateStr);
      List<KeyValueDto> list = Lists.newArrayList();
      for (String type : types) {
        EnergyConsume consume = energyConsumeMapper.selectByDateAndType(dateStr, type);
        KeyValueDto kv = new KeyValueDto(type, null == consume ? 0d : consume.getRate());
        list.add(kv);
      }
      dto.setGroup2RateList(list);
      energyConsume.add(dto);
    }
    secondLeftDto.setEnergyConsume(energyConsume);

    List<MaterialAnalysisDto> materialAnalysis = Lists.newArrayList();
    for (int i = 0; i < 7; i++) {

      MaterialAnalysisDto dto = new MaterialAnalysisDto();
      String dateStr = getDateStr(6 - i);
      dto.setDate(dateStr);
      MaterialAnalysis m1 = materialAnalysisMapper.selectByDateAndType(dateStr, "采购");
      MaterialAnalysis m2 = materialAnalysisMapper.selectByDateAndType(dateStr, "消耗");
      KeyValueDto a = new KeyValueDto("采购", null == m1 ? 0d : m1.getRate());
      KeyValueDto b = new KeyValueDto("消耗", null == m2 ? 0d : m2.getRate());
      dto.setGroup2RateList(Lists.newArrayList(a, b));
      materialAnalysis.add(dto);
    }
    secondLeftDto.setMaterialAnalysis(materialAnalysis);

    List<KeyValueDto> completionRate = Lists.newArrayList();
    for (int i = 0; i < 7; i++) {
      String dateStr = getDateStr(6 - i);
      ComplateRate rate = complateRateMapper.selectByDate(dateStr);
      KeyValueDto kv = new KeyValueDto(dateStr, null == rate ? 0d : rate.getRate());
      completionRate.add(kv);
    }
    secondLeftDto.setCompletionRate(completionRate);

    return secondLeftDto;
  }

  public FirstRightDto getFirstRight() {

    FirstRightDto firstRightDto = new FirstRightDto();

    List<ProcedureProcess> processList = procedureProcessMapper.selectAll();
    Product product = productMapper.selectOne();

    Map<String, Double> goodRate = Maps.newHashMap();
    for (int i = 0; i < processList.size(); i++) {
      ProcedureProcess p = processList.get(i);
      goodRate.put(p.getName() + "良品率", p.getGoodrate());
    }
    firstRightDto.setGoodRate(goodRate);

    List<KeyValueDto> openDefect = null;
    if (null != product && null != product.getOpendefect()) {
      openDefect = new Gson()
          .fromJson(product.getOpendefect(), new TypeToken<List<KeyValueDto>>() {
          }.getType());
    }
    firstRightDto.setOpenDefect(openDefect);

    //查询前七天
    List<KeyValueDto> depotEfficiency = Lists.newArrayList();
    for (int i = 0; i < 7; i++) {

      String dateStr = getDateStr(6 - i);
      DepotEfficiency efficiency = depotEfficiencyMapper.selectByDate(dateStr);
      KeyValueDto kv = new KeyValueDto(dateStr, null == efficiency ? 0d : efficiency.getRate());
      depotEfficiency.add(kv);
    }
    firstRightDto.setDepotEfficiency(depotEfficiency);

    return firstRightDto;
  }

  public SecondRightDto getSecondRight() {

    SecondRightDto secondRightDto = new SecondRightDto();

    List<String> groups = groupRateMapper.selectGroups();

    List<GroupRateDto> groupRate = Lists.newArrayList();
    for (int i = 0; i < 7; i++) {
      GroupRateDto groupRateDto = new GroupRateDto();
      String dateStr = getDateStr(6 - i);
      groupRateDto.setDate(dateStr);

      List<KeyValueDto> list = Lists.newArrayList();
      for (String group : groups) {
        GroupRate rate = groupRateMapper.selectByDateAndGroup(dateStr, group);
        KeyValueDto kv = new KeyValueDto(group, rate.getRate());
        list.add(kv);
      }
      groupRateDto.setGroup2RateList(list);
      groupRate.add(groupRateDto);
    }
    secondRightDto.setGroupRate(groupRate);

    Product product = productMapper.selectOne();
    List<KeyValueDto> perfQuality = null;
    if (null != product && null != product.getPerfquality()) {
      perfQuality = new Gson()
          .fromJson(product.getPerfquality(), new TypeToken<List<KeyValueDto>>() {
          }.getType());
    }

    secondRightDto.setPerfQuality(perfQuality);

    List<ProblemStatistics> problemStatisticsList = problemStatisticsMapper.selectAll();
    List<KeyValueDto> problemStatistics = Lists.newArrayList();
    for (ProblemStatistics problem : problemStatisticsList) {
      KeyValueDto kv = new KeyValueDto(problem.getName(), problem.getRate());
      problemStatistics.add(kv);
    }
    secondRightDto.setProblemStatistics(problemStatistics);

    return secondRightDto;
  }

  /**
   * 获取字符串格式时间，格式yyyy-MM-dd
   */
  private String getDateStr(int i) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - i);
    return calendar.get(Calendar.YEAR) + "-" + ((calendar.get(Calendar.MONTH) + 1) < 10 ? "0" + (
        calendar.get(Calendar.MONTH) + 1) : (calendar.get(Calendar.MONTH) + 1))
        + "-" + calendar.get(Calendar.DAY_OF_MONTH);
  }
}
