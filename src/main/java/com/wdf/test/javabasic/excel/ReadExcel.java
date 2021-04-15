package com.wdf.test.javabasic.excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName: readExcel
 * @Author WDF
 * @Description //TODO
 * @Date 2021/4/14 15:33
 * @Copyright Dareway 2021/4/14
 * @Version 1.0
 **/
public class ReadExcel {

    private static Logger logger = LoggerFactory.getLogger(ReadExcel.class);

    public static void main(String[] args) throws Exception {
        //不支持Excel2007格式（也就是xlsx格式文件）
        String name = "D:\\交易记录-2021-04-08.xls";
        List<Map<String,List<List<Object>>>> excelData = new ArrayList<>();
        Workbook workbook =   WorkbookFactory.create(new File(name)); // 自动判断格式
        Iterator<Sheet> sheetItr = workbook.sheetIterator();
        while (sheetItr.hasNext()){
            Sheet oneSheet = sheetItr.next();
            // excel单个页的最大尺寸，行数，列数，防止空行与单元格
            int rows = oneSheet.getLastRowNum(); //最大行数， 从0开始的，所以长度加1，但是
            int cols = 0; //最大列数
            for (int i = 0; i < rows + 1; i++) {
                if (oneSheet.getRow(i) == null){
                    continue;
                }
                int curCols = oneSheet.getRow(i).getLastCellNum(); //已经加1了
                cols = Math.max(cols,curCols);
            }
            if (rows > 0) rows += 1; // 0表示这页没有内容，加1会出错
            logger.info("sheet size:{} {}",rows,cols);
            String oneSheetName = oneSheet.getSheetName();
            Map<String,List<List<Object>>> sheetDataMap = new HashMap<>();
            // 单页没有数据
            if (rows == 0){
                sheetDataMap.put(oneSheetName,null);
                excelData.add(sheetDataMap);
                continue;
            }
            List<List<Object>> sheetData = new ArrayList<>();
            sheetDataMap.put(oneSheetName,sheetData);
            excelData.add(sheetDataMap);
            for (int i = 0; i < rows; i++) {
                List<Object> rowData = new ArrayList<>();
                Row oneRow = oneSheet.getRow(i);
                if ( oneRow == null){
                    sheetData.add(fakeEmptyRow(cols));
                    continue;
                }
                sheetData.add(rowData);
                for (int j = 0; j < cols; j++) {
                    Cell oneCell = oneRow.getCell(j);
                    if (oneCell == null || oneCell.getCellTypeEnum() == CellType.BLANK
                            || (oneCell.getCellTypeEnum() == CellType.STRING && oneCell.getStringCellValue().length() == 0)){
                        if (oneCell == null){
                            rowData.add(null);
                        }else if(oneCell.getCellTypeEnum() == CellType.BLANK){ //空单元格
//                                rowData.add("blank"); // debug
                            rowData.add(null);
                        }else if(oneCell.getCellTypeEnum() == CellType.STRING && oneCell.getStringCellValue().length() == 0){ //空字符
//                                rowData.add("nullStr"); // debug
                            rowData.add(null);
                        }
                    }else{
                        System.out.println(getCellValue(oneCell));
                        //rowData.add(getCellValue(oneCell));
                    }
                }
            }
        }
        //for()
        //return excelData;
    }

    private static Object getCellValue(Cell oneCell){
        Object cellValue = null;
        switch (oneCell.getCellTypeEnum()) {
            case NUMERIC:
                cellValue = oneCell.getNumericCellValue();
                break;
            case STRING:
                cellValue = oneCell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(oneCell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue = oneCell.getCellFormula();
                break;
            case BLANK:
                cellValue = null;
                break;
            case ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    private static List<Object> fakeEmptyRow(int cols){
        List<Object> fakeRow = new ArrayList<>();
        for (int i = 0; i < cols; i++) {
            fakeRow.add(null);
        }
        return fakeRow;
    }



    /**
     * @Author WDF
     * @Description 完善读取的excel文件
     * @Date 2021/4/14 16:27
     * @Param []
     * @return java.util.List
     **/
    public static List readText() throws IOException, InvalidFormatException {
        String filePath = null;
        int startRow = 0;
        int endRow = 0;
        String channelFlag;
        String codeFormat;
        String separator;
        String jgbm;
        Workbook workbook = WorkbookFactory.create(new File(filePath)); // 自动判断格式
        Iterator<Sheet> sheetItr = workbook.sheetIterator();
        while (sheetItr.hasNext()) {
            Sheet oneSheet = sheetItr.next();
            // excel单个页的最大尺寸，行数，列数，防止空行与单元格
            int rows = oneSheet.getLastRowNum(); //最大行数， 从0开始的，所以长度加1，但是
            int cols = 0; //最大列数
            for (int i = 0; i < rows + 1; i++) {
                if (oneSheet.getRow(i) == null) {
                    continue;
                }
                int curCols = oneSheet.getRow(i).getLastCellNum(); //已经加1了
                cols = Math.max(cols, curCols);
            }
            // 单页没有数据
            if (rows == 0) {
                return null;
            }
            logger.info("文件行数，{} 列数：{}",rows + 1,cols);
            for (int i = (startRow - 1); i <= (rows - endRow); i++) {
            //for (int i = 0; i < rows; i++) {
                List<Object> rowData = new ArrayList<>();
                Row oneRow = oneSheet.getRow(i);
                if (oneRow == null) {
                    logger.error("文件出现空行！");
                    continue;
                }
                for (int j = 0; j < cols; j++) {
                    Cell oneCell = oneRow.getCell(j);
                    if (oneCell == null || oneCell.getCellTypeEnum() == CellType.BLANK){
                        logger.info("第{}个存在空值：{}",j,oneRow);
                    } else {
                        System.out.println(getCellValue(oneCell));
                        //rowData.add(getCellValue(oneCell));
                    }
                }
            }
        }
        return null;
    }
}
