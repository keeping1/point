package com.example.point.cmcc.request;

import com.example.point.cmcc.util.StringUtil;

/**
 * @auther wangkaiguang
 * @date 2019/5/7
 */
public class CMCCJF0005Request extends CMCCRequestBuilder {

    private String thirdAccount;
    private String mobile;
    private String reserved1;
    private String getReserved2;

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

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getGetReserved2() {
        return getReserved2;
    }

    public void setGetReserved2(String getReserved2) {
        this.getReserved2 = getReserved2;
    }
}
