package com.test.apiCase.basedata;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.NotNull;

/**
 * �ӿ���Ϣ��
 */

public class ApiInfo {
    @Excel(name="�ӿڱ��")
    @NotNull
    private String apiId;

    @Excel(name="�ӿ�����")
    @NotNull
    private String apiName;

    @Excel(name="�ӿڷ�ʽ")
    @NotNull
    private String apiMethod;

    @Excel(name="�ӿڵ�ַ")
    @NotNull
    private String apiUrl;

    @Excel(name="��������")
    @NotNull
    private String parameType;

    public ApiInfo() {
    }

    public ApiInfo(String apiId, String apiName, String apiMethod, String apiUrl, String parameType) {
        this.apiId = apiId;
        this.apiName = apiName;
        this.apiMethod = apiMethod;
        this.apiUrl = apiUrl;
        this.parameType = parameType;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getParameType() {
        return parameType;
    }

    public void setParameType(String parameType) {
        this.parameType = parameType;
    }

    @Override
    public String toString() {
        return "ApiInfo{" +
                "apiId='" + apiId + '\'' +
                ", apiName='" + apiName + '\'' +
                ", apiMethod='" + apiMethod + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", parameType='" + parameType + '\'' +
                '}';
    }
}
