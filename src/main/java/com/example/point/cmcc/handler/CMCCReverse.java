package com.example.point.cmcc.handler;

import com.example.point.cmcc.request.CMCCJF0008Request;
import com.example.point.cmcc.util.IdWorker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther wangkaiguang
 * @date 2019/5/10
 */
@RestController
public class CMCCReverse {

    String postUrl = "";



    @RequestMapping("reverse")
     public String reverse(HttpServletRequest request){

        String uname = (String) request.getSession().getAttribute("uname");
        String mobile = (String) request.getSession().getAttribute("phone");
        CMCCJF0008Request cmccjf0008Request = new CMCCJF0008Request();
        cmccjf0008Request.setInterCode("jf0008");
        cmccjf0008Request.setCharacter("00");
        cmccjf0008Request.setIpAddress("127.0.0.1");
        cmccjf0008Request.setPartnerId("2100");
        cmccjf0008Request.setRequestId("asd");
        cmccjf0008Request.setSignType("md5");
        cmccjf0008Request.setType("web");
        cmccjf0008Request.setVersion("1.0.0");
        //扣减冲正流水号
        IdWorker idWorker = new IdWorker();
        cmccjf0008Request.setReTradeID(idWorker.nextId());
        //对应扣减交易流水好
        cmccjf0008Request.setDeTradeID();
        ///第三方账号
        cmccjf0008Request.setThirdAccount(uname);
        //手机号
        cmccjf0008Request.setMobile(mobile);
        //冲正积分值
        cmccjf0008Request.setAndpoint();
        //第三方冲正值
        cmccjf0008Request.setThirdPoint();
        //备注
        cmccjf0008Request.setComments("账户信息对不上");

        return "";
    }


}
