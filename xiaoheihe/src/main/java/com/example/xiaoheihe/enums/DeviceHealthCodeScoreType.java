package com.example.xiaoheihe.enums;

public enum DeviceHealthCodeScoreType {
    GZ("故障"),
    HCF("基础分"),
    GYSHDM("供应商"),
    TQ("退役"),
    QX("缺陷"),
    XS("巡视");


    String name;

    DeviceHealthCodeScoreType(String name) {
        this.name = name;
    }
}
