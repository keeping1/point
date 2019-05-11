package com.example.point.cmcc.handler;

import com.example.point.cmcc.request.CMCCJF0006Request;
import com.example.point.cmcc.service.*;
import com.example.point.cmcc.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/**
 * @auther wangkaiguang
 * @date 2019/5/8
 */
@RestController
public class CMCCExchangePoint {
@Autowired
    UserDao userDao;
@Autowired
    PointTransDao pointTransDao;
@Autowired
    HttpServletRequest request;
String postUrl = "http://10.1.102.97:9090/jfInter";
@RequestMapping("exchangePoint1")
public ModelAndView exchangePoint(){

    String userid = (String) request.getSession().getAttribute("uname");
    String mobile = (String)request.getSession().getAttribute("phone") ;
    CMCCJF0006Request cmccjf0006Request = new CMCCJF0006Request();

    ModelAndView modelAndView = new ModelAndView();

    cmccjf0006Request.setInterCode("jf0006");
    cmccjf0006Request.setCharacter("00");
    cmccjf0006Request.setIpAddress("127.0.0.0");
    cmccjf0006Request.setPartnerId("2100");
    cmccjf0006Request.setRequestId("asd");
    cmccjf0006Request.setSignType("md5");
    cmccjf0006Request.setType("web");
    cmccjf0006Request.setVersion("1.0.0");
    cmccjf0006Request.setThirdAccount(userid);
    cmccjf0006Request.setMobile(mobile);
    //验证码
    //cmccjf0006Request.setOptCode();
    //验证码标识
    cmccjf0006Request.setSmsCodeId("123456wkg");
    //雪花算法，获取流水号
    IdWorker c = new IdWorker();
    long idwork = c.nextId();
    cmccjf0006Request.setDeTradeID(idwork+"wkg");
    //要扣的积分值
    //cmccjf0006Request.setAndPoint();
    //第三方积分值
    cmccjf0006Request.setThirdPoint("500");
    //把报文放入map
    LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put("interCode",cmccjf0006Request.getInterCode());
    linkedHashMap.put("character",cmccjf0006Request.getCharacter());
    linkedHashMap.put("ipAddress",cmccjf0006Request.getIpAddress());
    linkedHashMap.put("partnerId",cmccjf0006Request.getPartnerId());
    linkedHashMap.put("requestId",cmccjf0006Request.getRequestId());
    linkedHashMap.put("signType",cmccjf0006Request.getSignType());
    linkedHashMap.put("type",cmccjf0006Request.getType());
    linkedHashMap.put("version",cmccjf0006Request.getVersion());
    linkedHashMap.put("thirdAccount",cmccjf0006Request.getThirdAccount());
    linkedHashMap.put("mobile",cmccjf0006Request.getMobile());
    StringBuilder stringBuilder = new StringBuilder();
    for (String key :linkedHashMap.keySet()){
        stringBuilder.append(linkedHashMap.get(key));
    }
    String hmac = MD5Util.md5(stringBuilder.toString() + MD5Util.defaultKey);
    cmccjf0006Request.setHmac(hmac);
    linkedHashMap.put("hmac",hmac);
    //发送请求
    String s = JF0005PostUtil.postMap(postUrl, linkedHashMap);
    //发送要获取的返回参数
    String mobile1 = StringUtil1.getMoblieUrl(s, "mobile");
    String thirdAccount = StringUtil1.getMoblieUrl(s, "thirdAccount");
    String point = StringUtil1.getMoblieUrl(s, "andPoint");

    return modelAndView;
}

    @RequestMapping("/beginExchange")
    public String successExchange(String idcode, String orderid, HttpServletResponse response) throws IOException {
        String userid = (String) request.getSession().getAttribute("uname");
        String mobile = (String)request.getSession().getAttribute("phone") ;
    PointTransExample pointTransExample=new PointTransExample();
        pointTransExample.createCriteria().andMobileEqualTo(mobile);
        List<PointTrans> pointTrans = this.pointTransDao.selectByExample(pointTransExample);
        PointTrans pointTrans1 = pointTrans.get(0);
        pointTrans1.setStatus("01");
        this.pointTransDao.updateByExample(pointTrans1,pointTransExample);
        String id = pointTrans1.getId();
        Integer point = pointTrans1.getPoint();
        double spoint=(double)point/1.2;

        ModelAndView modelAndView = new ModelAndView();
        CMCCJF0006Request cmccjf0006Request = new CMCCJF0006Request();

        cmccjf0006Request.setInterCode("jf0006");
        cmccjf0006Request.setCharacter("00");
        cmccjf0006Request.setIpAddress("127.0.0.0");
        cmccjf0006Request.setPartnerId("2100");
        cmccjf0006Request.setRequestId("asd");
        cmccjf0006Request.setSignType("md5");
        cmccjf0006Request.setType("web");
        cmccjf0006Request.setVersion("1.0.0");
        cmccjf0006Request.setThirdAccount(userid);
        cmccjf0006Request.setMobile(mobile);
        //验证码
        cmccjf0006Request.setOptCode(idcode);
        //验证码标识
        cmccjf0006Request.setSmsCodeId("123456wkg");
        //雪花算法，获取流水号
        IdWorker c = new IdWorker();
        long idwork = c.nextId();
        cmccjf0006Request.setDeTradeID(idwork+"wkg");
        //要扣的积分值
        cmccjf0006Request.setAndPoint(point.toString());
        //第三方积分值
        cmccjf0006Request.setThirdPoint("500");
        //把报文放入map
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("interCode",cmccjf0006Request.getInterCode());
        linkedHashMap.put("character",cmccjf0006Request.getCharacter());
        linkedHashMap.put("ipAddress",cmccjf0006Request.getIpAddress());
        linkedHashMap.put("partnerId",cmccjf0006Request.getPartnerId());
        linkedHashMap.put("requestId",cmccjf0006Request.getRequestId());
        linkedHashMap.put("signType",cmccjf0006Request.getSignType());
        linkedHashMap.put("type",cmccjf0006Request.getType());
        linkedHashMap.put("version",cmccjf0006Request.getVersion());

        linkedHashMap.put("thirdAccount",cmccjf0006Request.getThirdAccount());
        linkedHashMap.put("mobile",cmccjf0006Request.getMobile());
        linkedHashMap.put("optCode",cmccjf0006Request.getOptCode());
        linkedHashMap.put("smsCodeId",cmccjf0006Request.getSmsCodeId());
        linkedHashMap.put("deTradeID",cmccjf0006Request.getDeTradeID());
        linkedHashMap.put("andPoint",cmccjf0006Request.getAndPoint());
        linkedHashMap.put("thirdPoint",cmccjf0006Request.getThirdPoint());
        StringBuilder stringBuilder = new StringBuilder();
        for (String key :linkedHashMap.keySet()){
            stringBuilder.append(linkedHashMap.get(key));
        }
        String hmac = MD5Util.md5(stringBuilder.toString() + MD5Util.defaultKey);
        cmccjf0006Request.setHmac(hmac);
        linkedHashMap.put("hmac",hmac);

        String s = PostUtil.postMap(postUrl, linkedHashMap);
        System.out.println(s);
        String ret = StringUtil1.getMoblieUrl(s, "returnCode");
        System.out.println(ret);
        String msg = StringUtil1.getMoblieUrl(s, "message");
        System.out.println(msg);
        String data="[{"

                +"\"ret\":"+"\""+ret+"\""+","
                +"\"msg\":"+"\""+msg+"\""+

                "}]";

        System.out.println(s);
        System.out.println(data);
        response.getWriter().print(data);
        return null;
    }
    @RequestMapping("/createOrder")
    public String createOrder(User user,String outerpoints,String points,
                              String servicefee,String pointstype,
                              String rate,HttpServletResponse response ) throws ServletException, IOException {

        String mobile = (String)request.getSession().getAttribute("phone") ;
        String uname = (String)request.getSession().getAttribute("uname") ;

        //  点击确定提交就生成一个订单
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());

        // 扣减的积分
        PointTrans pointTrans=new PointTrans();
        pointTrans.setId(format);
        pointTrans.setPoint(Integer.parseInt(outerpoints));

        pointTrans.setType(servicefee);
        // 预支付状态时00
        pointTrans.setStatus("00");
        pointTrans.setUserId("9527");
        pointTrans.setMobile(mobile);
        pointTrans.setCreateTime(new Date());
        pointTransDao.insert(pointTrans);
        response.getWriter().print(pointTrans.getId());
        user.setUsername(uname);
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(uname);
        List<User> users = userDao.selectByExample(example);
        System.out.println(users);
        user.setPoint(Integer.parseInt(outerpoints));

        userDao.updateByExample(user,example);

        return null;
    }

}
