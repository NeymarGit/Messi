package com.test.apiCase.utils;

import com.test.apiCase.basedata.TMaUser;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * ִ��sql���
 */

public class SqlUtils {

    public static void main(String[] args) throws Exception{
        String selectSql = "select hight from t_ma_user where id = 1002;";
        double beforValue = selectColum(selectSql);
        updateSql();
        double afterValue = selectColum(selectSql);
        if(beforValue == afterValue){
            System.out.println("���Գɹ�");
        }else{
            System.out.println("����ʧ��");
        }


    }

    private static QueryRunner runner = new QueryRunner();
    // ��ȡ���ݿ�����
   private static Connection conn = JDBCUtils.getConnection();

    // ִ�в�ѯ���,����map���͵�һ����ѯ���
    public static void selectMap(String sql) throws Exception{
        // ����map���͵�һ����ѯ���
        MapHandler handler = new MapHandler();
        Map<String, Object> query = runner.query(conn, sql, handler);
        System.out.println(query);
    }

    // ����map���͵Ķ�����ѯ���
    public static void selectMaps(String sql) throws Exception{
        MapListHandler listHandler = new MapListHandler();
        List<Map<String, Object>> query1 = runner.query(conn, sql, listHandler);
        System.out.println(query1);
        System.out.println("----------------------------");

    }

    // ִ�в�ѯ���,���ض�������
    public static void selectBean(String sql) throws SQLException {
        // ���ض������͵�һ����ѯ���
        BeanHandler bh = new BeanHandler(TMaUser.class);
        Object query2 = runner.query(conn, sql, bh);
        System.out.println(query2);
        }


    // ִ�в�ѯ���,���ض�������
    public static void selectBeans(String sql) throws SQLException {
        // ���ض������͵Ķ�����ѯ���
        BeanListHandler<TMaUser> blh = new BeanListHandler<>(TMaUser.class);
        List<TMaUser> query3 = runner.query(conn, sql, blh);
        for(TMaUser user : query3){
            System.out.println(user);
        }
    }

    // ��ѯĳ��ָ���ֶε�ֵ
    public static Double selectColum(String sql) throws SQLException {
        // ���ض������͵�һ����ѯ���
        ScalarHandler<Double> scalarHandler = new ScalarHandler<>();
        double query4 = runner.query(conn, sql, scalarHandler);
        System.out.println(query4);
        return query4;
    }

    // ִ����ɾ��sql
    public static void updateSql() throws SQLException {
        String sql = "update t_ma_user set hight = 1.85 where id = 1002;";
        String sql1 = "INSERT INTO `t_ma_user`(`name`, `pwd`, `hight`, `remark`) VALUES ('meul', 'hehe', 1.24,'����3����');";

        // ִ��sql���
        int update = runner.update(conn, sql);
        System.out.println(update);
//        JDBCUtils.close(conn);
    }



}
