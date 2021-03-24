package com.apiauto.apiCase.runcase;

import com.apiauto.apiCase.basedata.ApiInfo;
import com.apiauto.apiCase.basedata.CaseInfo;
import com.apiauto.apiCase.constant.Constant;
import com.apiauto.apiCase.utils.DataUtils;
import com.apiauto.apiCase.utils.ExcelUtil;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RunJuheApi extends BaseRunCase {

    @Test(dataProvider = "datas")
    public void run(ApiInfo apiInfo, CaseInfo caseInfo) {
        // ���ýӿ�
        String response = call(apiInfo, caseInfo);
        log.info("=======��������===========" + response);
        // ���ö��Է���
        String way = assertWay(response, caseInfo);
        // �洢��д������
        addWriteBackContent(caseInfo, Constant.EXCEL_CELL_RESPONSE, response, way);
    }

    @AfterSuite
    // ��д��Ӧ���ݵ�Excel
    public void finish() {
        ExcelUtil.writeBack(Constant.EXCEL_PATH);
    }

    @DataProvider(name = "datas")
    public Object[][] getDatas() {
        Object[][] datas = DataUtils.getINfoList(Constant.EXCEL_PATH, Constant.ZUOWEN);
        return datas;
    }

}
