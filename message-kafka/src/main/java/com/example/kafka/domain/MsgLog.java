package com.example.kafka.domain;


import java.util.Date;

public class MsgLog  {
    private String msgId;
    private String msg;
    private String exchange;
    private String routingKey;
    private Integer status;
    private Integer tryCount;
    private Integer maxTryCount;
    private Integer consumeTryCount;
    private Date nextTryTime;
    private Integer messageLevel;
    private Date createTime;
    private Date updateTime;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    public Integer getMaxTryCount() {
        return maxTryCount;
    }

    public void setMaxTryCount(Integer maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    public Integer getConsumeTryCount() {
        return consumeTryCount;
    }

    public void setConsumeTryCount(Integer consumeTryCount) {
        this.consumeTryCount = consumeTryCount;
    }

    public Date getNextTryTime() {
        return nextTryTime;
    }

    public void setNextTryTime(Date nextTryTime) {
        this.nextTryTime = nextTryTime;
    }

    public Integer getMessageLevel() {
        return messageLevel;
    }

    public void setMessageLevel(Integer messageLevel) {
        this.messageLevel = messageLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
