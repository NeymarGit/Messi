package com.apiauto.apiCase.basedata;

/**
 * ���Ա��ʽ��Ԫ�����ݵ�ӳ��
 */
public class AssertJson {
    // ����ֵ
    private String value;
    // ���Ա��ʽ
    private String expression;

    public AssertJson(String value, String expression) {
        this.value = value;
        this.expression = expression;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
