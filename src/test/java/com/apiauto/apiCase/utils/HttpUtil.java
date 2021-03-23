package com.apiauto.apiCase.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

/**
 * ����http�ӿڹ�����
 * ����url,����,�ӿڷ�ʽ,�������ͣ����ؽӿ�response��Ϣ
 */

 //���ݴ���Ĳ����ж��������ýӿ�
public class HttpUtil {

    public static CloseableHttpResponse httpUtils(String url,String apiMethod,String parameType,String params){
        if("post".equalsIgnoreCase(apiMethod)){
            if("json".equalsIgnoreCase(parameType)){
                return HttpUtil.postRequestJson(url,params);
            }else if("form".equalsIgnoreCase(parameType)){
                return HttpUtil.postRequestForm(url,params);
            }
        }else if("get".equalsIgnoreCase(apiMethod)){
            return HttpUtil.getRequestJson(url,params);
        }
        return null;
    }

    //���ò�������Ϊform��post�ӿ�
    public static CloseableHttpResponse postRequestForm(String url, String param){
        Logger log = Logger.getLogger(HttpUtil.class);

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type","application/x-www-form-urlencoded");
            post.addHeader("Jenkins-Crumb","3f3923b17469ce3a6b4150ed53aa8589496f5ac892facb014f1e0804e3035103");
            post.addHeader("Cookie","JSESSIONID=0F5FFF6495D15884504A948681CC2855");
            // ������õ�cookie�����cookie
//            CookieUtil.addCookie(post);

            post.setEntity(new StringEntity(param));
            response = client.execute(post);
            CookieUtil.setCookie(response); //�������ֵ��cookie�������

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }


    //���ò�������Ϊjson��post�ӿ�

    public static CloseableHttpResponse postRequestJson(String url, String param){
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Content-Type","application/json");
            post.setEntity(new StringEntity(param));
            CookieUtil.addCookie(post);

            response = client.execute(post);
            CookieUtil.setCookie(response); //�������ֵ��cookie�������

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

    //����get�ӿ�
    public static CloseableHttpResponse getRequestJson(String url, String param){
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpGet get = new HttpGet(url+"?"+param);
            response = client.execute(get);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }
}
