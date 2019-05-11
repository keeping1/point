package com.example.point.cmcc.request;

import com.sun.xml.internal.bind.v2.model.core.ReferencePropertyInfo;

/**
 * @auther wangkaiguang
 * @date 2019/5/10
 */
public class CMCCJF0008Request extends CMCCRequestBuilder{

   private long reTradeID;
   private String deTradeID;
   private String thirdAccount;
   private String mobile;
   private String andpoint;
   private String thirdPoint;
   private String comments;
   private String reserved1;
   private String reserved2;

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    public long getReTradeID() {
        return reTradeID;
    }

    public void setReTradeID(long reTradeID) {
        this.reTradeID = reTradeID;
    }

    public String getDeTradeID() {
        return deTradeID;
    }

    public void setDeTradeID(String deTradeID) {
        this.deTradeID = deTradeID;
    }

    public String getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(String thirdAccount) {
        this.thirdAccount = thirdAccount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAndpoint() {
        return andpoint;
    }

    public void setAndpoint(String andpoint) {
        this.andpoint = andpoint;
    }

    public String getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(String thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }
}
