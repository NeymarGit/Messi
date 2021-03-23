package com.test.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {
    public static void main(String[]args)throws Exception{

        //1.�ҵ�excel
        FileInputStream fis=new FileInputStream("src/test/java/com/test/excel/student.xlsx");
        //2.��excel
        Workbook workbook=WorkbookFactory.create(fis);

        //3.��ȡsheet
        Sheet sheet=workbook.getSheet("2�·ݹ���");

        //4.��ȡ��Ԫ��
        Row row = sheet.getRow(2);
        if(row == null){ //���ǿ��жϣ���ֹ��ָ��
            row = sheet.createRow(2);
        }
        Cell cell = row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

        //5.�޸�ֵ
        cell.setCellValue("1502");

        //6.�����д����Excel
        FileOutputStream fos = new FileOutputStream("src/test/java/com/test/excel/student.xlsx");
        workbook.write(fos); //�����

        fis.close();
        fos.close();
    }
}
