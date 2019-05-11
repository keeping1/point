package com.example.point.cmcc.handler;

import com.example.point.cmcc.request.CMCCJF0001Request;
import com.example.point.cmcc.request.Result;
import com.example.point.cmcc.service.*;
import com.example.point.cmcc.util.MD5Util;
import com.example.point.cmcc.util.PostUtil;
import com.example.point.cmcc.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @auther wangkaiguang
 * @date 2019/5/5
 */
@RestController
public class CMCCHandler {

    @Autowired
    BindingInfoDao bindingInfoDao;
    @Autowired
    UserDao userDao;
    //登录页面
    @Autowired
    HttpServletRequest request;
     @RequestMapping("toLogin")
        public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login1");
        return modelAndView;
     }
     @RequestMapping("toCheckLogin")
        public ModelAndView toCheckLogin(User user, HttpServletRequest request){
         UserExample example = new UserExample();
         example.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
         userDao.selectByExample(example);
         String uname = user.getUsername();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login1");
        return modelAndView;
     }
     @RequestMapping("toExchange")
        public ModelAndView toExchange(User user, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
         Object phone = request.getSession().getAttribute("phone");
         modelAndView.addObject(phone);
        modelAndView.setViewName("exchange");
        return modelAndView;
     }
     //跳转到积分页面
     @RequestMapping("toYeMian")
        public ModelAndView toYeMian(User user){
         //取出用户信息
         String uname = user.getUsername();
         String pwd = user.getPassword();
       //把用户信息放入session中
         request.getSession().setAttribute("uname",uname);
         request.getSession().setAttribute("pwd",pwd);
         request.getSession().setAttribute("phone","18721735939");
         //跳转页面
         UserExample example = new UserExample();
         example.createCriteria().andUsernameEqualTo(uname);
         List<User> c = userDao.selectByExample(example);

         System.out.println(c);

         ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("butler");

        return modelAndView;
     }

     //检测用户是否绑定手机号
     @RequestMapping("check")
        public ModelAndView check(User user, HttpServletResponse response, Result result) throws IOException {
         String uname = (String) request.getSession().getAttribute("uname");
         System.out.println(uname);
         BindingInfoExample example = new BindingInfoExample();
         example.createCriteria().andUseridEqualTo(uname);
         List<BindingInfo> list = bindingInfoDao.selectByExample(example);
         PrintWriter writer = response.getWriter();
         if(uname==""){
             result.setCode(0);
         }else {
             result.setCode(1);
         }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("butler");
        return modelAndView;
     }


    //接口的地址
    String postUrl ="http://10.1.102.97:9090/jfInter";
    @RequestMapping("/doBinding")
    public String doBinding(HttpServletResponse response,User user) throws IOException {
        //从request中获取
        String userId = (String) request.getSession().getAttribute("uname");
        //创建对象获取值
        CMCCJF0001Request cmccjf0001Request = new CMCCJF0001Request();
        cmccjf0001Request.setInterCode("jf0001");
        cmccjf0001Request.setCharacter("00");
        cmccjf0001Request.setIpAddress("127.0.0.1");
        cmccjf0001Request.setPartnerId("2100");
        cmccjf0001Request.setRequestId("asd");
        cmccjf0001Request.setType("web");
        cmccjf0001Request.setSignType("MD5");
        cmccjf0001Request.setVersion("1.0.0");
        cmccjf0001Request.setThirdAccount(userId);//自己的平台账号（唯一），从数据库获取
        BindingInfoExample example = new BindingInfoExample();
        example.createCriteria().andUseridEqualTo(userId).andAppidEqualTo("2100");
        //查询userid是否存在
        List<BindingInfo> list = bindingInfoDao.selectByExample(example);
        if (list.size()<=0) {
            BindingInfo bindingInfo = new BindingInfo();
            bindingInfo.setAppid("2100");
            bindingInfo.setIntime(new Date());
            bindingInfo.setModtime(new Date());
            bindingInfo.setMobileid("");
            bindingInfo.setBindingtimes("0");
            bindingInfo.setUserid(userId);
            bindingInfo.setState("02");
            bindingInfoDao.insert(bindingInfo);
        }
        //回调接口
        cmccjf0001Request.setCallbackUrl("http://127.0.0.1:9091/callback");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("interCode",cmccjf0001Request.getInterCode());
        linkedHashMap.put("character",cmccjf0001Request.getCharacter());
        linkedHashMap.put("ipAddress",cmccjf0001Request.getIpAddress());
        linkedHashMap.put("partnerId",cmccjf0001Request.getPartnerId());
        linkedHashMap.put("requestId",cmccjf0001Request.getRequestId());
        linkedHashMap.put("type",cmccjf0001Request.getType());
        linkedHashMap.put("signType",cmccjf0001Request.getSignType());
        linkedHashMap.put("version",cmccjf0001Request.getVersion());
        linkedHashMap.put("thirdAccount",cmccjf0001Request.getThirdAccount());
        linkedHashMap.put("callbackUrl",cmccjf0001Request.getCallbackUrl());
        StringBuilder macBuilder = new StringBuilder();
        for (
                String key:linkedHashMap.keySet()
             ) {
           macBuilder.append(linkedHashMap.get(key));
        }
     String hmac = MD5Util.md5(macBuilder.toString()+MD5Util.defaultKey);
        cmccjf0001Request.setHmac(hmac);
        linkedHashMap.put("hmac",hmac);
          String returnstr = PostUtil.postMap(postUrl,linkedHashMap);
        String returnUrl = StringUtil.getMoblieUrl(returnstr);
        System.out.println(returnstr);
        response.sendRedirect(returnUrl);
          return "redirect:http://www.baidu.com";
    }

    //回调接口
    @RequestMapping("/callback")
     public ModelAndView callback(HttpServletRequest request){
       String thirdAccount = request.getParameter("thirdAccount");
        String mobile = request.getParameter("mobile");
        BindingInfoExample example = new BindingInfoExample();
        example.createCriteria().andUseridEqualTo(thirdAccount).andAppidEqualTo("2100");
        List<BindingInfo> list = bindingInfoDao.selectByExample(example);
        //获取list中的第一个数据
        BindingInfo bindingInfo = list.get(0);
        //把数据放入自己的数据库
        bindingInfo.setState("01");
        bindingInfo.setModtime(new Date());
        bindingInfo.setBindingtimes(Integer.parseInt(bindingInfo.getBindingtimes())+1+"");
        bindingInfo.setMobileid(mobile);
        bindingInfo.setOuterUserid(thirdAccount);
        //修改
        bindingInfoDao.updateByPrimaryKey(bindingInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exchange");
        return modelAndView;
    }
}
