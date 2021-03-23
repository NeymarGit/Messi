package com.test.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetHttpClient {
    public static void main(String[] args) throws Exception{

        //1.������������Ŀͻ���
        CloseableHttpClient client = HttpClients.createDefault();

        //2������request����,�������ͷ
        HttpGet get = new HttpGet("http://api.lemonban.com/futureloan/loans");
        get.addHeader("X-Lemonban-Media-Type","lemonban.v1");

        //3���ͻ��˷���get����,����response
        CloseableHttpResponse response = client.execute(get);

        //4����ȡ��Ӧ��Ϣ
        Header[] headers = response.getAllHeaders(); //������Ӧͷ
        int code = response.getStatusLine().getStatusCode();//��Ӧ״̬��
        HttpEntity entity = response.getEntity(); // ��Ӧ��
        String str = EntityUtils.toString(entity); //��ʽ����Ӧ��

        System.out.println("header:"+headers);
        System.out.println("statuscode:"+code);
        System.out.println("entity:"+entity);




    }
}
