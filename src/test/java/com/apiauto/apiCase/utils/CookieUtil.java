package com.apiauto.apiCase.utils;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ȡCookie����������ͷ���cookie
 */

public class CookieUtil {
    // ��������
    private static Map<String,String> cookieMap = new HashMap<String,String>();


    // �����ȡ����cookie
    public static void setCookie(CloseableHttpResponse response){
        // �ӷ�����Ϣ�л�ȡCookie
        Header[] cookies = response.getHeaders("Set-Cookie");
        if(cookies.length != 0){
            for(Header cookie : cookies){
                // ��ȡ��Ҫ��cookie
                String value = cookie.getValue().substring(0,43);
                cookieMap.put("cookie",value);
            }
        }
    }

    // ���cookie������ͷ��
    public  static void addCookie(HttpRequestBase request){
        if(cookieMap.size() != 0){
            String cookie = cookieMap.get("cookie");
            request.addHeader("Cookie",cookie);
        }
    }

}
