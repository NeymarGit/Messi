package com.test.dataprovider;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * ����testng����xml�ļ�������
 */
public class testLiu {

    @Test
    @Parameters(value = {"type","version"})
    public void test(String type,String version){
        System.out.println("���Կ�ʼ");
        System.out.println(type);
        System.out.println(version);

    }


}
