package com.apiauto.apiCase.basedata;

/**
 * ���ڴ洢��д����
 */
public class WriteBackContent {
    // Ҫ��д����
    private String caseId;
    // Ҫ��д���ؽ������
    private String cellResponseNum;
    // Ҫ��д������
    private String content;
    //���Խ��
    private String flag;

    public WriteBackContent(String caseId, String cellNum, String content, String flag) {
        this.caseId = caseId;
        this.cellResponseNum = cellNum;
        this.content = content;
        this.flag = flag;
    }


    public WriteBackContent() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCellResponseNum() {
        return cellResponseNum;
    }

    public void setCellResponseNum(String cellResponseNum) {
        this.cellResponseNum = cellResponseNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
