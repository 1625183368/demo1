package com.example.xiaoheihe.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

public class Demo {
    private String mRID;
    private String remark;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String dmlCode;

    public String getmRID() {
        return mRID;
    }

    public void setmRID(String mRID) {
        this.mRID = mRID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDmlCode() {
        return dmlCode;
    }

    public void setDmlCode(String dmlCode) {
        this.dmlCode = dmlCode;
    }


    @Override
    public String toString() {
        return "Demo{" +
                "mRID='" + mRID + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", creator='" + creator + '\'' +
                ", dmlCode='" + dmlCode + '\'' +
                '}';
    }
}
