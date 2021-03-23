package com.apiauto.apiCase.utils;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.apiauto.apiCase.basedata.WriteBackContent;
import com.apiauto.apiCase.constant.Constant;
import org.apache.poi.ss.usermodel.*;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 1����Excel��ȡ������ӳ���java����
 * ����excel��ַ��sheetҳ������Ϣ������������Ӧ�����List
 * <p>
 * 2�������ص���Ϣ��д��Excel
 */

public class ExcelUtil {
    // �洢��д�����ݵ�list������������д�����Ч��
    public static List<WriteBackContent> contentList = new ArrayList<WriteBackContent>();

    // ȡ��excel�е�����ת����java����
    public static <T> List<T> excel2Api(String path, int sheetIndex, Class<T> clazz) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            //�����������Ĭ��ֵ��ȡ��ֻȡ��һ��sheet����ͷֻȡ��һ�У�
            ImportParams params = new ImportParams();
            params.setStartSheetIndex(sheetIndex);
            // params.setNeedVerfiy(true); // �ǿ�У��
            // ����excel��װ��List����
            List<T> list = ExcelImportUtil.importExcel(fis, clazz, params);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(fis);
        }
        return null;
    }

    //��дresponse��Excel
    public static void writeBack(String path) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1���ҵ�excel
            fis = new FileInputStream(path);
            //2����excel
            Workbook workbook = WorkbookFactory.create(fis);
            //3����ȡsheet
            Sheet sheet = workbook.getSheetAt(Constant.SHEET_CASE);
            //4����ȡ��Ԫ��
            // ����contentList�е�����,��ȡ���кţ��кź�����
            for (WriteBackContent wbc : contentList) {
                Row row = sheet.getRow(Integer.parseInt(wbc.getCaseId()));
                if (row == null) { //���ǿ��жϣ���ֹ��ָ��
                    row = sheet.createRow(Integer.parseInt(wbc.getCaseId()));
                }
                // ��ȡ��д�������ݵ���
                Cell cell1 = row.getCell(Integer.parseInt(wbc.getCellResponseNum()), Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                // ��ȡ��д���Խ������
                Cell cell2 = row.getCell(Integer.parseInt(wbc.getCellResponseNum())+1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                //5���޸�ֵ
                cell1.setCellValue(wbc.getContent());
                cell2.setCellValue(wbc.getFlag());

            }
            //6�������д����Excel
            fos = new FileOutputStream(path);
            workbook.write(fos); //�����

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(fis);
            close(fos);
        }
    }

    // �ر�IO��
    public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
