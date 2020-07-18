package com.wdf.test.javabasic.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelTest {
	
	public static void main(String[] args) {
		//testCreateExcel();
		try {
			testReconFile();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void testCreateExcel() {
        try {
        	File file = new File("D:\\a.xls");
            // 创建xls文件
            file.createNewFile();
            // 2:创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);

            // 3:创建sheet,设置第二三四..个sheet，依次类推即可
            WritableSheet sheet = workbook.createSheet("测试", 0);
            // 4：设置titles
            String[] titles = { "编号", "账号"};
            // 5:给第一行设置列名
            for (int i = 0; i < titles.length; i++) {
                sheet.addCell(new Label(i, 0, titles[i]));
            }
            sheet.setHeader("aa", "cc", "cc");
            // 6：模拟数据库导入数据 注意起始行为1
            for (int i = 1; i < 100; i++) {
                //添加编号
                sheet.addCell(new Label(0, i, new String("编号"+i)));
                //添加密码
                sheet.addCell(new Label(1, i, new String("编号"+i)));
            }
            workbook.write();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
	
	/**
	 * 
	 * @Title: testReconFile
	 * @author: WDF
	 * @throws WriteException 
	 * @throws IOException 
	 * @Description: 对账报表
	 * @date: 2020年7月16日 下午8:55:24
	 */
	public static void testReconFile() throws WriteException, IOException {
		OutputStream out = new FileOutputStream("D:\\recon.xls");
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(out);
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("对账详细信息", 0);
		// 构造表头
		sheet.mergeCells(0, 0, 18, 0);// 添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
		// 设置字体种类和黑体显示,字体为Arial,字号大小为10,采用黑体显示
		WritableFont bold = new WritableFont(WritableFont.ARIAL, 13, WritableFont.BOLD);
		WritableCellFormat titleFormate = new WritableCellFormat(bold);// 生成一个单元格样式控制对象
		titleFormate.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); //设置边框
		titleFormate.setAlignment(jxl.format.Alignment.CENTRE);// 单元格中的内容水平方向居中
		titleFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 单元格的内容垂直方向居中
		Label title = new Label(0, 0,   "山大大学附属生殖医院自主对账详细（"+"银联"+"）", titleFormate);
		sheet.setRowView(0, 360, false);// 设置第一行的高度
		sheet.addCell(title);
		
		//创建表头要显示的具体内容
		// 设置字体种类和黑体显示,字体为Arial,字号大小为10,采用黑体显示
		WritableFont hbold = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
		WritableCellFormat headFormate = new WritableCellFormat(hbold);// 生成一个单元格样式控制对象
		headFormate.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); //设置边框
		headFormate.setAlignment(jxl.format.Alignment.CENTRE);// 单元格中的内容水平方向居中
		headFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 单元格的内容垂直方向居中
		//headFormate.setWrap(true); //设置自动换行
		
		sheet.mergeCells(0, 1, 8, 1);
		sheet.addCell(new Label(0, 1, "银联", headFormate));
		sheet.mergeCells(9, 1, 13, 1);
		sheet.addCell(new Label(9, 1, "自助机", headFormate));
		sheet.mergeCells(14, 1, 17, 1);
		sheet.addCell(new Label(14, 1, "his部分", headFormate));
		sheet.mergeCells(18, 1, 18, 2);
		sheet.addCell(new Label(18, 1, "差异金额", headFormate));
		sheet.setColumnView(0,20);
		String[] titlesOne = {"清算日期","交易流水","交易日期","交易时间","终端号","交易金额","清算金额","手续费","交易类型"};
		String[] titlesTwo = {"自助流水","交易类型","终端编号","交易金额","交易时间"};
		String[] titlesThree = {"His交易流水","交易金额","卡号","交易时间"};
				
		for (int i = 0; i < titlesOne.length; i++) {
			sheet.addCell(new Label(i, 2, titlesOne[i], headFormate));
			if (i == 3) {
				sheet.setColumnView(i,20);
			}else {
				sheet.setColumnView(i,8);
			}
			if (i<titlesTwo.length) {
				sheet.addCell(new Label(i+9, 2, titlesTwo[i], headFormate));
				if (i+9 == 9) {
					sheet.setColumnView(i+9,20);
				}else {
					sheet.setColumnView(i+9,8);
				}
			}
			if (i<titlesThree.length) {
				sheet.addCell(new Label(i+14, 2, titlesThree[i], headFormate));
				if (i+14 == 14) {
					sheet.setColumnView(i+14,8);
				}else {
					sheet.setColumnView(i+14,13);
				}
			}
		}
		
		// 创建要显示的具体内容
		WritableFont color = new WritableFont(WritableFont.ARIAL);// 选择字体
		color.setColour(Colour.BLACK);// 设置字体颜色为黑色
		WritableCellFormat defaultFormat = new WritableCellFormat(color);
		//defaultFormat.setWrap(true); //设置自动换行
		//defaultFormat.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN); //设置边框
		String[] keys = {"qdmc","ynhisjyzje","sbjyzje","ynhisycjyzje","sbycjyzje",
				         "ynhisjyzbs","sbjyzbs","ynhisycjyzbs","sbycjyzbs",
				         "hisjyzje","qdjyzje","hisycjyzje","qdycjyzje",
				         "hisjyzbs","qdjyzbs","hisycjyzbs","qdycjyzbs"};
		/*if(StringUtils.isNotEmpty(reconResults)){
			for(int i=0; i<reconResults.size(); i++){ //详细内容
				DataObject record = reconResults.getRow(i);
				for (int j = 0; j < keys.length; j++) {
					Object cellValue = null;
					if ("ynhisjyzje".equalsIgnoreCase(keys[j].trim()) || "sbjyzje".equalsIgnoreCase(keys[j].trim()) 
					|| "ynhisycjyzje".equalsIgnoreCase(keys[j].trim()) || "sbycjyzje".equalsIgnoreCase(keys[j].trim())
					|| "hisjyzje".equalsIgnoreCase(keys[j].trim()) || "qdjyzje".equalsIgnoreCase(keys[j].trim())
					|| "hisycjyzje".equalsIgnoreCase(keys[j].trim()) || "qdycjyzje".equalsIgnoreCase(keys[j].trim())) {
						cellValue = record.containsKey(keys[j].trim()) ? record.getBigDecimal(keys[j]) : new BigDecimal(0);
						if(StringUtils.isEmpty(cellValue)) {
							cellValue = new BigDecimal(0);
						}
					} else if("ynhisjyzbs".equalsIgnoreCase(keys[j].trim()) || "sbjyzbs".equalsIgnoreCase(keys[j].trim()) 
							|| "ynhisycjyzbs".equalsIgnoreCase(keys[j].trim()) || "sbycjyzbs".equalsIgnoreCase(keys[j].trim())
							|| "hisjyzbs".equalsIgnoreCase(keys[j].trim()) || "qdjyzbs".equalsIgnoreCase(keys[j].trim())
							|| "hisycjyzbs".equalsIgnoreCase(keys[j].trim()) || "qdycjyzbs".equalsIgnoreCase(keys[j].trim())){
						cellValue = record.containsKey(keys[j].trim()) ? record.getInt(keys[j]) : null;
					}else {
						cellValue = record.containsKey(keys[j].trim()) ? record.getString(keys[j]) : null;
					}
					if (null == cellValue) {
						sheet.addCell(new Label(j, i+4, "", defaultFormat));
					} else {
						sheet.addCell(new Label(j, i+4, cellValue.toString(), defaultFormat));
					}
				}
			}
		}*/
		// 把创建的内容写入到输出流中，并关闭输出流
		workbook.write();
		workbook.close();
		out.close();
	}
}
