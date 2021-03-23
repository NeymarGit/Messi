package com.exam.excel;

import org.apache.poi.hssf.eventusermodel.dummyrecord.MissingRowDummyRecord;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelWrite {
    public static void main(String[] args) throws Exception {
        ExcelWrite ew  = new ExcelWrite();
        ew.list2Excel("src/test/java/com/exam/excel/exam.xlsx");
    }

    public void list2Excel(String path) throws Exception{


        WriteBackData wbd1 = new WriteBackData(1,2,"Pass1");
        WriteBackData wbd2 = new WriteBackData(2,2,"Fail1");
        WriteBackData wbd3 = new WriteBackData(3,2,"Success1");

        List<WriteBackData> list = new ArrayList<WriteBackData>();
        list.add(wbd1);
        list.add(wbd2);
        list.add(wbd3);


        //1���ҵ�excel
        FileInputStream fis = new FileInputStream(path);
        //2����excel
        Workbook workbook = WorkbookFactory.create(fis);
        //3����ȡsheet
        Sheet sheet = workbook.getSheet("Sheet1");

        //4����ȡ��Ԫ��
        for(WriteBackData temp: list){
            int rowNum = temp.getRowNum();
            int cellNum = temp.getCellNum();
            String content = temp.getContent();
            Row row = sheet.getRow(rowNum-1);
            //row��δʹ�ù��᷵��null
            if (null == row){
                row = sheet.createRow(rowNum-1);
            }
            Cell cell = row.getCell(cellNum-1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellValue(content); //5���޸�ֵ

        }

        //6�������д����Excel
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        fos.close();
        fis.close();

    }


}


