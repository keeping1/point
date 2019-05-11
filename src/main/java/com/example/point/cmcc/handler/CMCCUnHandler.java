package com.example.point.cmcc.handler;

import com.example.point.cmcc.request.CMCCJF0002Request;
import com.example.point.cmcc.service.BindingInfo;
import com.example.point.cmcc.service.BindingInfoDao;
import com.example.point.cmcc.service.BindingInfoExample;
import com.example.point.cmcc.util.MD5Util;
import com.example.point.cmcc.util.PostUtil1;
import com.example.point.cmcc.util.StringUtil;
import com.example.point.cmcc.util.StringUtil1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @auther wangkaiguang
 * @date 2019/5/6
 */
@RestController
public class CMCCUnHandler {

    @Autowired
    BindingInfoDao bindingInfoDao;
    @Autowired
    HttpServletRequest request;
   String postUrl ="http://10.1.102.97:9090/jfInter";
    @RequestMapping("unBinding")
     public String unBinding(HttpServletResponse response) throws IOException {

        String userdid = (String) request.getSession().getAttribute("uname");
        CMCCJF0002Request cmccjf0002Request = new CMCCJF0002Request();
        cmccjf0002Request.setInterCode("jf0002");
        cmccjf0002Request.setCharacter("00");
        cmccjf0002Request.setIpAddress("127.0.0.1");
        cmccjf0002Request.setPartnerId("2100");
        cmccjf0002Request.setRequestId("");
        cmccjf0002Request.setSignType("md5");
        cmccjf0002Request.setType("web");
        cmccjf0002Request.setVersion("1.0.0");
        cmccjf0002Request.setRole("00");
        cmccjf0002Request.setThirdAccount(userdid);//自己要解绑的账号
        cmccjf0002Request.setMobile("18721735939");

        //把报文数据放入map中，方便下面遍历
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("interCode",cmccjf0002Request.getInterCode());
        linkedHashMap.put("character",cmccjf0002Request.getCharacter());
        linkedHashMap.put("ipAddress",cmccjf0002Request.getIpAddress());
        linkedHashMap.put("partnerId",cmccjf0002Request.getPartnerId());
        linkedHashMap.put("requestId",cmccjf0002Request.getRequestId());
        linkedHashMap.put("signType",cmccjf0002Request.getSignType());
        linkedHashMap.put("type",cmccjf0002Request.getType());
        linkedHashMap.put("version",cmccjf0002Request.getVersion());
        linkedHashMap.put("role",cmccjf0002Request.getRole());
        linkedHashMap.put("thirdAccount",cmccjf0002Request.getThirdAccount());
        linkedHashMap.put("mobile",cmccjf0002Request.getMobile());

        //创建字符串集合
        StringBuilder stringBuilder = new StringBuilder();
        for ( String key:linkedHashMap.keySet()
             ) {
            stringBuilder.append(linkedHashMap.get(key));
        }
        //加签
        String hmac = MD5Util.md5(stringBuilder.toString()+MD5Util.defaultKey);
        cmccjf0002Request.setHmac(hmac);
        linkedHashMap.put("hmac",hmac);
        //发送请求
       String returnstr = PostUtil1.postMap(postUrl,linkedHashMap);
       //截取需要的字符串，传参
       String mobile = StringUtil1.getMoblieUrl(returnstr,"mobile");
       String thirdAccount = StringUtil1.getMoblieUrl(returnstr,"thirdAccount");
        //解绑
        BindingInfoExample bindingInfoExample = new BindingInfoExample();
        bindingInfoExample.createCriteria().andUseridEqualTo(thirdAccount);
        List<BindingInfo> list = bindingInfoDao.selectByExample(bindingInfoExample);
        BindingInfo bindingInfo = list.get(0);
        bindingInfo.setState("03");//03解绑
        //修改状态
       bindingInfoDao.updateByPrimaryKey(bindingInfo);
        return "redirect:http://www.baidu.com";
    }

}
