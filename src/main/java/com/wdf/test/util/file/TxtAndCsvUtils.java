package com.wdf.test.util.file;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TxtAndCsvUtils {
	// 日志初始化
	protected static Logger logger = LoggerFactory.getLogger(TxtAndCsvUtils.class);
	
	/**
	 * 读取TXT/CSV文件内容，从startRow开始读取，剔除倒数endRow行，
	 * 根据channelFlag确定字段，每行以separator分割
	 * @param filePath 文件路径，含文件名称
	 * @param startRow 从第几行开始读数据
	 * @param endRow 剔除最后几行
	 * @param codeFormat 文件编码格式
	 * @param separator 分隔符
	 * @throws IOException
	 */
	public static List readTxt(String filePath, int startRow, int endRow,
			String codeFormat, String separator, String key,Integer value) throws IOException {
		List records = new ArrayList();
        File file = new File(filePath);
        if (file.isFile() && file.exists() && file.canRead()) {
        	/*获取文件总行数*/
	        int totalLines = getTotalLineNum(filePath, codeFormat);
	        logger.info("文件总行数: " + totalLines);
            /*按需读取文件内容*/
        	BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), codeFormat));
        	String fileContent;
			int line = 0; // 记录行数
			Map<String,Object> record = new HashMap<String,Object>();
			// 获取需要赋值的字段及对应的列
			while ((fileContent = reader.readLine()) != null && fileContent.replace(",", "").trim().length() > 0
					&& fileContent.replace("�", "").trim().length() > 0) {
				line++;
				if (line < startRow) {
					continue; // 跳过startRow行之前的数据
				}
				if (line > (totalLines - endRow)) {
					continue; // 跳过最后endRow行
				}
            	// 如果为分隔符分割，则使用分割字符把一个字符串分割成字符串数组
				String[] fields = null;
				if (!separator.equals("") && separator != null) {
					fields = fileContent.split(separator, -1);
				}

				String rvalue = fields[value];
				//System.out.println(rvalue);
				if (rvalue.contains("`")) {
					rvalue = rvalue.replace("`", "");
				}
				record.put(rvalue.trim(), rvalue.trim());

				//records.add(record);
            }
			for (String k: record.keySet()) {
				System.out.println(k + " " + record.get(k));
			}
			System.out.println(records);
            reader.close();
            logger.info("文件数据读取完成 ");
            return records;
        } else {
        	logger.error("文件不存在!");
        	return null;
        }
    }

	/**
	 * 获取文件总行数
	 * @param filePath
	 * @param codeFormat
	 * @return
	 * @throws IOException
	 */
	public static int getTotalLineNum(String filePath, String codeFormat) throws IOException {
		File file = new File(filePath);
		if (file.isFile() && file.exists() && file.canRead()) {
			/*按需读取文件内容*/
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), codeFormat));
			String fileContent = null; // 读取文件的方法
			int line = 0; // 记录行数

			while ((fileContent = reader.readLine()) != null && fileContent.replace(",", "").trim().length()
					> 0 && fileContent.replace("�", "").trim().length() > 0) {
				line++;
			}
			reader.close();
			return line;
		} else {
			logger.error("文件不存在!");
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
//		String filePath = "E:\\20190401千佛山医院对账文件.txt"; // 读取文件的绝对路径
//		DataStore records = readTxt(filePath, 2, 0, UrpConstants.UNIONPAY_CARD_CHANNEL,
//				UrpConstants.ENCODING_FORMAT_GBK, UrpConstants.COMMA_SEPARATOR);
		String filePath = "E:\\zxyy_his_20210322.txt"; // 读取文件的绝对路径
		List records = readTxt(filePath, 2, 0,
				"GBK", ",", "key",5);

	}

}
