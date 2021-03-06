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
        // 调用接口
        String response = call(apiInfo, caseInfo);
        log.info("=======返回内容===========" + response);
        // 调用断言方法
        String way = assertWay(response, caseInfo);
        // 存储回写的内容
        addWriteBackContent(caseInfo, Constant.EXCEL_CELL_RESPONSE, response, way);
    }

    @AfterSuite
    // 回写响应数据到Excel
    public void finish() {
        ExcelUtil.writeBack(Constant.EXCEL_PATH);
    }

    @DataProvider(name = "datas")
    public Object[][] getDatas() {
        Object[][] datas = DataUtils.getINfoList(Constant.EXCEL_PATH, Constant.ZUOWEN);
        return datas;
    }

}
