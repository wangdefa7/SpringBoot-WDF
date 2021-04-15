package com.wdf.test.javabasic.excel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Author: 灵枢
 * Date: 2018/12/05
 * Time: 17:21
 * Description:读取Excel数据
 */
public class ExcelData {
    private XSSFSheet sheet;

    static void readXls(File inputFile)
    {
        try
        {
            // Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell;
            Row row;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext())
            {
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    cell = cellIterator.next();

                    switch (cell.getCellType())
                    {

                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;

                        case Cell.CELL_TYPE_STRING:
                            System.out.println(cell.getStringCellValue());
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            System.out.println(" ");
                            break;

                        default:
                            System.out.println(cell);
                    }
                }
            }

        }

        catch (FileNotFoundException e)
        {
            System.err.println("Exception" + e.getMessage());
        }
        catch (IOException e)
        {
            System.err.println("Exception" + e.getMessage());
        }
    }

    //测试方法
    public static void main(String[] args){
        String name = "D:\\交易记录-2021-04-08.xls";
        File inputFile = new File(name);
        readXls(inputFile);
    }
}


