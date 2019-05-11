package com.example.point.cmcc.request;

/**
 * @auther wangkaiguang
 * @date 2019/5/5
 */
public class CMCCJF0001Request extends CMCCRequestBuilder {

    private String thirdAccount;
    private String callbackUrl;
    private String reserved1;
    private String reserved2;

    public String getThirdAccount() {
        return thirdAccount;
    }

    public void setThirdAccount(String thirdAccount) {
        this.thirdAccount = thirdAccount;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }
}
