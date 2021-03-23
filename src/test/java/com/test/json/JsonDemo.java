package com.test.json;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java�����json�ַ���ת��
 */
public class JsonDemo {
    public static void main(String[] args) {
        //json�ַ���ת��Ϊ����
        String str = "{name : \"liuyanghe\",age : \"18\",high : \"1.78\"}";
        Student stu = JSONObject.parseObject(str, Student.class);
        System.out.println(stu.getName());
        System.out.println(stu.getAge());
        System.out.println(stu.getHigh());

        //����ת��Ϊjson�ַ���
        Student s1 = new Student("wushaugn",16,1.60);
        String json = JSONObject.toJSONString(s1);
        System.out.println(json);

        //mapתjson�ַ���
        Map<String , String > map = new HashMap<String, String>();
        map.put("name","liu");
        map.put("age","18");
        map.put("high","1.99");
        String json1 = JSONObject.toJSONString(map);
        System.out.println(json1);



        //json�ַ���ת��ΪList,Lsit����Ŷ���
        String str1 = "[{name : \"��\",age : \"11\",high : \"1.18\"},{name : \"��\",age : \"12\",high : \"1.28\"}]";
        List<Student> list = JSONObject.parseArray(str1, Student.class);
        for (Student s:list){
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getHigh());
        }
        System.out.println(list);
    }
}
