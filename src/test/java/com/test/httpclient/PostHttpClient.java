package com.test.httpclient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class PostHttpClient {
    public static void main(String[] args) throws Exception{

    PostHttpClient.httpPost("http://localhost:8080/jenkins/securityRealm/createAccount","");

    }

    public static void httpPost(String url,String parameter){
        try {
            //1.������������Ŀͻ���
            CloseableHttpClient client = HttpClients.createDefault();

            //2������request����,�������ͷ
            HttpPost post = new HttpPost(url);
//            post.addHeader("X-Lemonban-Media-Type","lemonban.v1");
//            post.addHeader("Content-Type","application/json");  //bug:"Content-Type"���л��ߡ�-��
             post.addHeader("Content-Type","application/x-www-form-urlencoded");  //����ʽ
            //2.1������post��������������
//            StringEntity se = new StringEntity("{\"username\":+\"yu\",+\"password1\":+\"123456\",+\"password2\":+\"123456\",+\"fullname\":+\"yu\",+\"Jenkins-Crumb\":+\"454b707ba6275be3d9893dbfce248494\"}");
            StringEntity se = new StringEntity("username=yu2&password1=123456&password2=123456&fullname=yu2&Jenkins-Crumb=454b707ba6275be3d9893dbfce248494&json=%7B%22username%22%3A+%22yu%22%2C+%22password1%22%3A+%22123456%22%2C+%22password2%22%3A+%22123456%22%2C+%22fullname%22%3A+%22yu%22%2C+%22Jenkins-Crumb%22%3A+%22454b707ba6275be3d9893dbfce248494%22%7D&Submit=%E6%B3%A8%E5%86%8C");
            post.setEntity(se);
            //3���ͻ��˷���get����,����response
//            HttpHost proxy = new HttpHost("localhost",8888);//���ô���
//            CloseableHttpResponse response = client.execute(proxy,post);
            CloseableHttpResponse response = client.execute(post);

            //4����ȡ��Ӧ��Ϣ
            Header[] headers = response.getAllHeaders(); //������Ӧͷ
            int code = response.getStatusLine().getStatusCode();//��Ӧ״̬��
            HttpEntity entity = response.getEntity(); // ��Ӧ��
            String str = EntityUtils.toString(entity); //��ʽ����Ӧ��

            System.out.println("header:"+headers);
            System.out.println("statuscode:"+code);
            System.out.println("entity:"+str);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
