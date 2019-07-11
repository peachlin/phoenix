package com.zmsj.phoenix.model.sqlserver;

public class TeilWithBLOBs extends Teil {

  private String tebem;

  private String te1799;

  public String getTebem() {
    return tebem;
  }

  public void setTebem(String tebem) {
    this.tebem = tebem == null ? null : tebem.trim();
  }

  public String getTe1799() {
    return te1799;
  }

  public void setTe1799(String te1799) {
    this.te1799 = te1799 == null ? null : te1799.trim();
  }
}