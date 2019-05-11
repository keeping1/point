package com.example.point.cmcc.util;

import com.example.point.cmcc.request.CMCCJF0006Request;
import com.example.point.cmcc.request.CMCCJFD001Request;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class JF0006PostUtil {

    public static void main(String[] args,HttpServletRequest request) throws Exception {


        String uname = (String)request.getSession().getAttribute("uname");
        String mobile =(String) request.getSession().getAttribute("mobile");
        CMCCJF0006Request cmccjf0006Request = new CMCCJF0006Request();

        cmccjf0006Request.setInterCode("jf0006");
        cmccjf0006Request.setCharacter("00");
        cmccjf0006Request.setIpAddress("127.0.0.0");
        cmccjf0006Request.setPartnerId("2100");
        cmccjf0006Request.setRequestId("asd");
        cmccjf0006Request.setSignType("md5");
        cmccjf0006Request.setType("web");
        cmccjf0006Request.setVersion("1.0.0");
        cmccjf0006Request.setThirdAccount(uname);
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

        StringBuilder macString= new StringBuilder();
        StringBuilder postBulilder = new StringBuilder();

        for(Object key:linkedHashMap.keySet()){
            postBulilder.append("&").append(key).append("=").append(linkedHashMap.get(key));
            macString.append(linkedHashMap.get(key));
        }
        String hmac = MD5Util.md5(macString.toString()+MD5Util.defaultKey);
        cmccjf0006Request.setHmac(hmac);
        postBulilder.append("&hmac=").append(hmac);
        linkedHashMap.put("hmac",hmac);
        System.out.println("postBulilder="+postBulilder);
//        sendPost("http://172.30.47.241:9090/jfInter",postBulilder.toString());
       String st2r=  postMap("http://10.1.102.97:9090/jfInter",linkedHashMap);
       System.out.println(st2r);
    }

    public static String httpPostWithJSON(String url,String str) throws Exception {

        HttpPost httpPost = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;

//        json方式
        StringEntity entity = new StringEntity("?interCode=JF0001&character=00&ipAddress=127.0.0.1&partnerId=2100&requestId=asd&type=web&signType=md5&version=1.0.0&thirdAccount=1234566789&callbackUrl=http://127.0.0.1:9091/callback1&hmac=c895ed00fa501fd7ed0e12b23d8cac66","utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/form-data");
        httpPost.setEntity(entity);
        System.out.println();
        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }

    public static String postMap(String url,Map<String,String> map) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
            response = httpClient.execute(post);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    private static String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if(entity != null)
        {
            long lenth = entity.getContentLength();
            if(lenth != -1 && lenth < 2048)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }

}
