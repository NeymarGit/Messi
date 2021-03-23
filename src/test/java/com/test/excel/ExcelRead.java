package com.test.excel;

import org.apache.poi.hpsf.MissingSectionException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelRead {
    public static void main(String[] args) throws Exception {
        //1���ҵ�excel
        FileInputStream fis = new FileInputStream("src/test/java/com/test/excel/student.xlsx");

        //2����excel
        Workbook workbook = WorkbookFactory.create(fis);

        //3����ȡsheet
        Sheet sheet = workbook.getSheet("1�·ݹ���");

//        //4����ȡ��
//        Row row = sheet.getRow(0);
//
//        //5����ȡ��Ԫ��
//        Cell cellId = row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);//�����Ԫ����򴴽�һ��cell����,�����ָ��
//        cellId.setCellType(CellType.STRING); //���õ�Ԫ���ʽΪString
//        System.out.println(cellId.getStringCellValue());
//        Cell cellname = row.getCell(1);
//        System.out.println(cellname.getStringCellValue());
//        Cell cellSalary = row.getCell(2);
//        System.out.println(cellSalary.getStringCellValue());

        //6��ȡ�����е�Ԫ������
        int lastRowNum = sheet.getLastRowNum(); //��ȡ�������
        for (int i = 0; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum(); //��ȡ��ǰ�е����һ����Ԫ��
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue+",");
            }
            System.out.println();
        }
        fis.close();
    }
}
