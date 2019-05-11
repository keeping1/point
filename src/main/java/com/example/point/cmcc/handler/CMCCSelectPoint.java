package com.example.point.cmcc.handler;

import com.example.point.cmcc.request.CMCCJF0005Request;
import com.example.point.cmcc.service.BindingInfo;
import com.example.point.cmcc.service.BindingInfoDao;
import com.example.point.cmcc.util.JF0005PostUtil;
import com.example.point.cmcc.util.MD5Util;
import com.example.point.cmcc.util.StringUtil1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @auther wangkaiguang
 * @date 2019/5/7
 */
@RestController
public class CMCCSelectPoint {

    @Resource
    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    BindingInfoDao bindingInfoDao;
    @Autowired
    HttpServletRequest request;
    //要调取的接口
    String postUrl ="http://10.1.102.97:9090/jfInter";
    @RequestMapping("selectPoint")
    public ModelAndView selectPoint(){
        ModelAndView modelAndView = new ModelAndView();
        String userid = (String) request.getSession().getAttribute("uname");
        String mobile1 = (String) request.getSession().getAttribute("mobile");

        CMCCJF0005Request cmccjf0005Request = new CMCCJF0005Request();
        cmccjf0005Request.setInterCode("jf0005");
        cmccjf0005Request.setCharacter("00");
        cmccjf0005Request.setIpAddress("127.0.0");
        cmccjf0005Request.setPartnerId("2100");
        cmccjf0005Request.setRequestId("asd");
        cmccjf0005Request.setSignType("md5");
        cmccjf0005Request.setType("web");
        cmccjf0005Request.setVersion("1.0.0");
        cmccjf0005Request.setThirdAccount(userid);
        cmccjf0005Request.setMobile(mobile1);

        //把报文放入map
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("interCode",cmccjf0005Request.getInterCode());
        linkedHashMap.put("character",cmccjf0005Request.getCharacter());
        linkedHashMap.put("ipAddress",cmccjf0005Request.getIpAddress());
        linkedHashMap.put("partnerId",cmccjf0005Request.getPartnerId());
        linkedHashMap.put("requestId",cmccjf0005Request.getRequestId());
        linkedHashMap.put("signType",cmccjf0005Request.getSignType());
        linkedHashMap.put("type",cmccjf0005Request.getType());
        linkedHashMap.put("version",cmccjf0005Request.getVersion());
        linkedHashMap.put("thirdAccount",cmccjf0005Request.getThirdAccount());
        linkedHashMap.put("mobile",cmccjf0005Request.getMobile());

        StringBuilder stringBuilder = new StringBuilder();
       for (String key :linkedHashMap.keySet()){
           stringBuilder.append(linkedHashMap.get(key));
       }
        String hmac = MD5Util.md5(stringBuilder.toString() + MD5Util.defaultKey);
       cmccjf0005Request.setHmac(hmac);
       linkedHashMap.put("hmac",hmac);
       //发送请求
        String s = JF0005PostUtil.postMap(postUrl, linkedHashMap);
        //发送要获取的返回参数
        String mobile = StringUtil1.getMoblieUrl(s, "mobile");
        String thirdAccount = StringUtil1.getMoblieUrl(s, "thirdAccount");
        String point = StringUtil1.getMoblieUrl(s, "andPoint");
        //把获取到的point

        Set<Object> point1 = redisTemplate.boundSetOps("point").members();
        if (point1.size()!=0){

        }
        modelAndView.addObject("point",point);
        modelAndView.addObject("money",Integer.parseInt(point)/100);
        modelAndView.setViewName("butler");
        return modelAndView;
    }

    @RequestMapping("login")
    public ModelAndView login(){



        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
