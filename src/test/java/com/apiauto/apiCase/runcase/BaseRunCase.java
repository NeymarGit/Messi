package com.apiauto.apiCase.runcase;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.apiauto.apiCase.basedata.ApiInfo;
import com.apiauto.apiCase.basedata.AssertJson;
import com.apiauto.apiCase.basedata.CaseInfo;
import com.apiauto.apiCase.basedata.WriteBackContent;
import com.apiauto.apiCase.utils.ExcelUtil;
import com.apiauto.apiCase.utils.HttpUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ��װ���ýӿڷ��� �� ��ӻ�д���ݵ�Content��
 */

public class BaseRunCase {
    // log4j��־
    protected Logger log = Logger.getLogger(BaseRunCase.class);

    //���ýӿڷ���
    public String call(ApiInfo apiInfo, CaseInfo caseInfo) {
        String apiurl = apiInfo.getApiUrl();
        String apiMethod = apiInfo.getApiMethod();
        String paraType = apiInfo.getParameType();
        String para = caseInfo.getPara();

        CloseableHttpResponse response = HttpUtil.httpUtils(apiurl, apiMethod, paraType, para);
        try {
            // bug��һ��httpclient���ص�responseֻ����һ��
            return EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ����ӿ���Ӧ�� caseinfo�е�����ֵ�Ͷ��Ա��ʽ
    public String assertWay(String response, CaseInfo caseInfo) {
        List<Boolean> flagList = new ArrayList<>();
        try {
            if(caseInfo.getAsserts() == null){
                return null;
            }else {
                // ��Excel�е�����ֵ�Ͷ��Ա��ʽ��Ԫ�������ݣ�ת����java���� ��ŵ�list��
                List<AssertJson> assertJsonList = JSONObject.parseArray(caseInfo.getAsserts(), AssertJson.class);
                for (AssertJson aj : assertJsonList) {
                    // ����jsonpath��ȡ��Ӧ����е� ʵ��ֵ
                    Object actualValue = JSONPath.read(response, aj.getExpression());
                    // �Ƚ�����ֵ��ʵ��ֵ
                    boolean flag = aj.getValue().equalsIgnoreCase(actualValue.toString());
                    log.info("�������:" + aj.getValue());
                    log.info("ʵ�ʽ��:" + actualValue.toString());
                    log.info(flag);
                    flagList.add(flag);
                }
                return flagList.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // �����Ҫ��д�����ݵ�list��
    public void addWriteBackContent(CaseInfo caseInfo, String cellNum, String response, String flag) {
        // ����Ҫ��д������ת����WriteBackContent����
        WriteBackContent wbc = new WriteBackContent(caseInfo.getCaseId(), cellNum, response, flag);
        // ��ӵ�list��
        ExcelUtil.contentList.add(wbc);
    }

}
