package com.example.kafka.domain;


public class MessageContent {
    private String queueName;
    private String exchangeName;
    private String routingKey;
    private Integer messageLevel;
    private Integer delayTime;
    private Integer maxTryCount;
    private Object content;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public Integer getMessageLevel() {
        return messageLevel;
    }

    public void setMessageLevel(Integer messageLevel) {
        this.messageLevel = messageLevel;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    public Integer getMaxTryCount() {
        return maxTryCount;
    }

    public void setMaxTryCount(Integer maxTryCount) {
        this.maxTryCount = maxTryCount;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
