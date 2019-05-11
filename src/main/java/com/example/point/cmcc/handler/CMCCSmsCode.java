package com.example.point.cmcc.handler;

import com.example.point.cmcc.request.CMCCJFD001Request;
import com.example.point.cmcc.service.*;
import com.example.point.cmcc.util.JFD001PostUtil;
import com.example.point.cmcc.util.MD5Util;
import com.example.point.cmcc.util.StringUtil1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @auther wangkaiguang
 * @date 2019/5/8
 */
@RestController
public class CMCCSmsCode {

    @Autowired
    UserDao userDao;
    @Autowired
    PointTransDao pointTransDao;
    String postUrl ="http://10.1.102.97:9090/jfInter";
    @RequestMapping("/smsCode")
    public String smsCode(HttpServletRequest request){
        CMCCJFD001Request cmccjfd001Request = new CMCCJFD001Request();
        cmccjfd001Request.setInterCode("jfd001");
        cmccjfd001Request.setCharacter("00");
        cmccjfd001Request.setIpAddress("127.0.0.0");
        cmccjfd001Request.setPartnerId("2100");
        cmccjfd001Request.setRequestId("ASD");
        cmccjfd001Request.setSignType("md5");
        cmccjfd001Request.setType("web");
        cmccjfd001Request.setVersion("1.0.0");
        cmccjfd001Request.setThirdAccount("2");
        cmccjfd001Request.setMobile("18721735939");
        cmccjfd001Request.setOtpType("JF0006");

        //把数据放入map
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("interCode",cmccjfd001Request.getInterCode());
        linkedHashMap.put("character",cmccjfd001Request.getCharacter());
        linkedHashMap.put("ipAddress",cmccjfd001Request.getIpAddress());
        linkedHashMap.put("partnerId",cmccjfd001Request.getPartnerId());
        linkedHashMap.put("requestId",cmccjfd001Request.getRequestId());
        linkedHashMap.put("signType",cmccjfd001Request.getSignType());
        linkedHashMap.put("type",cmccjfd001Request.getType());
        linkedHashMap.put("version",cmccjfd001Request.getVersion());
        linkedHashMap.put("thirdAccount",cmccjfd001Request.getThirdAccount());
        linkedHashMap.put("mobile",cmccjfd001Request.getMobile());
        linkedHashMap.put("otpType",cmccjfd001Request.getOtpType());

        StringBuilder stringBuilder = new StringBuilder();
        for (String key :linkedHashMap.keySet()){
            stringBuilder.append(linkedHashMap.get(key));
        }
        String hmac = MD5Util.md5(stringBuilder.toString() + MD5Util.defaultKey);
        cmccjfd001Request.setHmac(hmac);
        linkedHashMap.put("hmac",hmac);
        //发送请求
        String s = JFD001PostUtil.postMap(postUrl, linkedHashMap);
        System.out.println(s);
        //获取账号
        String thirdAccount = StringUtil1.getMoblieUrl(s,"thirdAccount");
        String mobile = StringUtil1.getMoblieUrl(s,"mobile");
        PointTransExample example = new PointTransExample();
        example.createCriteria().andUserIdEqualTo(thirdAccount).andMobileEqualTo(mobile);
        List<PointTrans> list = pointTransDao.selectByExample(example);
        //获取数据
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());

        PointTrans pointTrans = new PointTrans();
        pointTrans.setId(format);
        pointTrans.setPoint(100);
        pointTrans.setType("01");
        pointTrans.setStatus("00");
        pointTrans.setUserId(thirdAccount);
        pointTrans.setMobile(mobile);
        pointTrans.setCreateTime(new Date());
        pointTransDao.insert(pointTrans);
        return "";
    }

}
