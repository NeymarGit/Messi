package com.apiauto.apiCase.utils;

import com.apiauto.apiCase.basedata.ApiInfo;
import com.apiauto.apiCase.basedata.CaseInfo;
import com.apiauto.apiCase.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * ��API��case�������������ض�ά����,��dataprovider��
 */
public class DataUtils {
    public static Object[][] getINfoList(String path, String apiId) {

        ApiInfo api = new ApiInfo();
        // һ��API��Ӧ���Caseinfo�����Լ�List
        List<CaseInfo> caselist = new ArrayList<CaseInfo>();
        // Excel�л�ȡ��������API�ŵ�List��
        List<ApiInfo> apiInfos = ExcelUtil.excel2Api(path, Constant.SHEET_API, ApiInfo.class);
        // Excel�л�ȡ��������Case�ŵ�List��
        List<CaseInfo> caseInfos = ExcelUtil.excel2Api(path, Constant.SHEET_CASE, CaseInfo.class);

        // ����API��list�����ִ����apiId��List�е�apiIdһ�£���ȡ����
        for (ApiInfo apiInfo : apiInfos) {
            if(apiId.equals(apiInfo.getApiId())){
                api = apiInfo;
            }
        }

        // ����case��list�����ִ����apiId��LIst�е�apiIdһ�£���ȡ�������ŵ��µ�list��
        for (CaseInfo caseInfo : caseInfos) {
            if(apiId.equals(caseInfo.getApiId())){
               caselist.add(caseInfo);
            }
        }

        // ��API���� ��Case����ͨ��apiId��Ӧ�������ŵ���ά�����У���ΪdataProvider����
        Object[][] datas = new Object[caselist.size()][2];
        for (int i = 0; i < caselist.size(); i++) {
            datas[i][0] = api;
            datas[i][1] = caselist.get(i);
        }
        return datas;
    }


}
