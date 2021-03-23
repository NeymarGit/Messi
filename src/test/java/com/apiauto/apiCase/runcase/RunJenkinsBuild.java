package com.apiauto.apiCase.runcase;

import com.apiauto.apiCase.basedata.ApiInfo;
import com.apiauto.apiCase.basedata.CaseInfo;
import com.apiauto.apiCase.constant.Constant;
import com.apiauto.apiCase.utils.DataUtils;
import com.apiauto.apiCase.utils.ExcelUtil;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RunJenkinsBuild extends BaseRunCase {

    @Test(dataProvider = "datas")
    public void run(ApiInfo apiInfo, CaseInfo caseInfo){
        String response = call(apiInfo, caseInfo);
        log.info("--------·µ»ØÄÚÈÝ--------" + response);
//        String way = assertWay(response, caseInfo);
//        addWriteBackContent(caseInfo, Constant.EXCEL_CELL_RESPONSE,response,way);
    }

    @AfterSuite
    public void finish(){
        ExcelUtil.writeBack(Constant.EXCEL_PATH);
    }

    @DataProvider(name = "datas")
    public Object[][] getDatas(){
        Object[][] datas = DataUtils.getINfoList(Constant.EXCEL_PATH, Constant.JENKINS_BUILD);
        return datas;
    }
        
}
