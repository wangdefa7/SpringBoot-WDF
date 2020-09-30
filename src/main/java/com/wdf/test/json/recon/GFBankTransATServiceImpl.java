package com.wdf.test.json.recon;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class GFBankTransATServiceImpl  {
	
	private static Logger logger = LoggerFactory.getLogger(GFBankTransATServiceImpl.class);

	public String aip = "localhost";

	/**
	 * 方法简介 :根据para中的时间段获取overtime_refund中的批次号，遍历获取每一批的流水信息，汇总存到一个DataStore里面
	 * @Title: getfinDataStore（）
	 * @author: L_Y
	 * param: start:yyyymmdd end:yyyymmdd
	 * @date:   2020年9月23日17:25:11
	 */
	@RequestMapping("/gf")
	@ResponseBody
	public String getfinDataStore(@RequestParam String id) throws Exception {

		Map finResult=new HashMap();//存储最终查询结果和返回信息
		List finDS=new ArrayList();//保存查询结果集合的DataStore
		//获取入参DataStore(包含para指示日期内所有batchno)，新逻辑入参只传batchNo
		List cgb0034rc=new ArrayList();

        cgb0034rc.add("20200814133800");
        cgb0034rc.add("20200821160746");
        cgb0034rc.add("20200821160746");
        cgb0034rc.add("20200814143708");
        cgb0034rc.add("20200814143708");
        cgb0034rc.add("20200814143149");
        cgb0034rc.add("20200814143149");
        cgb0034rc.add("20200714155049");
        cgb0034rc.add("20200715091348");
        cgb0034rc.add("20200715092159");
        cgb0034rc.add("20200715102938");cgb0034rc.add("20200715110817");
        cgb0034rc.add("20200729144019");
        cgb0034rc.add("20200729144019");
        cgb0034rc.add("20200814133800");cgb0034rc.add("20200814104917");cgb0034rc.add("20200731171755");
        cgb0034rc.add("20200702140626");
        cgb0034rc.add("20200702140626");
        cgb0034rc.add("20200702140626");
        cgb0034rc.add("20200706100832");
        cgb0034rc.add("20200706100832");
        cgb0034rc.add("20200706100832");
        cgb0034rc.add("20200706100832");
        try{
            if (id != "" || null != id){
                cgb0034rc.add(id);
            }
        }catch (Exception e){
            logger.error("输入数据有异常");
            e.printStackTrace();
        }



        for(Object rcObj:cgb0034rc){//1、多批次
			String result=transDetails0034(rcObj.toString());//调接口获取返参
			FileOutputStream fileOutPutSream = new FileOutputStream("D:\\aTest.txt");
			fileOutPutSream.write("测试数据写入".getBytes());
			fileOutPutSream.close();
			System.out.println("end");
		}//遍历批次结束

		//执行插入、更新逻辑
		//String msg=classifyAndUpdateDataStore(finDS,para);

//		finResult.put("finDS",finDS);
//		finResult.put("msg",msg);
		return "oK";
	}



	/**方法简介 :广发批量转账交易结果查询接口（0034）获得数据
	 * @Title: transDetails0034
	 * @author: L_Y
	 * @throws Exception
	 * @date:   2020年7月17日09:40:35
	 */

	public String transDetails0034(String para) throws Exception {
		Map result = new HashMap();//保存返回结果集
		String cgb_data = transDetailsXml0034(para);
		logger.info("查询入参："+cgb_data);
		logger.info(aip +"&&&&&");
		String url = "http://"+ aip +":24/CGBClient/BankAction"; //设置一个前置机地址和端口号
		String rep = HttpUtil.doPostBank(url, cgb_data);
		//TODO 测试数据 接口文档返回数据示例
//		rep="<?xml version="1.0" encoding="gbk" ?><BEDC><Message><commHead><tranCode>0032</tranCode><cifMaster>1000135170</cifMaster><entSeqNo>201712250032112608</entSeqNo><tranDate>20171225</tranDate><tranTime>112608</tranTime><retCode>000</retCode><entUserId>100001</entUserId><password>624ee25b195211cb9918a85718cfb7ba1ceab587122d1094058be4da1a383a51909b10d53e2808402aa558c81395ba38c7a6b94034fd69913d5d389cfca06e2881a5be9c26171a25624398f26f71f557c979c69e7c188853dc18faa70bd15ebca310192eb8a7d16825382a6235888e8bd121ad574ee929fc8124023b7ade3c4b</password></commHead><Body><account>134001505010001248</account><totalNum>1</totalNum><pageFlag>0</pageFlag><nextRecTranDate/><nextRecTranSeq/><nextRecTranCode/><reserve1>20171225</reserve1><reserve2>201712250032112608</reserve2><records><record><serialNo>0000000845770001</serialNo><dealDate>20171225</dealDate><loanSign>-</loanSign><dealMoney>100.00</dealMoney><financingSymbol>+</financingSymbol><usableMoney>502537509462.48</usableMoney><Abstract>网银转出</Abstract><dealBranch>199999</dealBranch><upBill/><oppoAccno>129011512010008241</oppoAccno><name>衅剔壳驶鸦罗声堰鬓轿匈屈备魂</name><rcvBankId>129011</rcvBankId><dealTime>112758</dealTime><abstractContent>0011附言</abstractContent><dealChannel>EIB</dealChannel><summary>0011备注</summary><postScript>0011附言</postScript><oppAccountType>1</oppAccountType><uniqueCode>199999201712250000000845770001</uniqueCode><cbsTranSeq>0001</cbsTranSeq><reserve1>20171225</reserve1><reserve2>201712250032112608</reserve2></record></records></Body></Message></BEDC>"
		JSONObject jsonObject = XmlUtil.xmlToJson(rep);
		logger.info("广发批量转账交易结果查询:" + jsonObject);

		return jsonObject.toString();
		/*String retCode=jsonObject.getJSONObject("Message").getJSONObject("commHead").getString("retCode");
		if("000".equals(retCode)||"888".equals(retCode)){
			JSONObject body = jsonObject.getJSONObject("Message").getJSONObject("Body");
			//所有子流水信息
			JSONObject records = body.getJSONObject("records");

			String customerBatchNo=body.getString("customerBatchNo");//客户批次号
			String account=body.getString("accountNo");//付款账号
			int size=body.getIntValue("allCount");//总计交易笔数
			String allSalary=body.getString("allSalary");//总计交易金额
			String allHandlefee=body.getString("allHandlefee");//总计交易手续费
			int count=body.getIntValue("count");//成功笔数
			int allErrCount=body.getIntValue("errCount");//失败笔数
			int unknowCount=body.getIntValue("unknowCount");//正在处理笔数

			result.put("customerBatchNo",customerBatchNo);
			result.put("accountNo",account);
			result.put("allCount",size);
			result.put("allSalary",allSalary);
			result.put("allHandlefee",allHandlefee);
			result.put("count",count);
			result.put("errorCount",allErrCount);
			result.put("unknowCount",unknowCount);


			int flag = 1; //是否全部转账成功  //拿到终态后，停止轮询
			if (unknowCount <= 0) {
				result.put("errorcode", "0");
				result.put("errortext", "转账完成，成功"+ count + "笔，失败" + allErrCount + "笔。");
				//return result;
			} else {
				result.put("errortext","本批转账存在处理中笔数 "+unknowCount+" 笔。");
			}

			//处理records
			List recordsForSingleBatch= new ArrayList();//保存records
			Map singleRecord=new HashMap();//保存一条record
			for (int l = 0; l < size; l++) {
				JSONObject res = new JSONObject();
				if (size == 1) {
					res = records.getJSONObject("record");
				}else {
					res = records.getJSONArray("record").getJSONObject(l);
				}

				String refundno = res.getString("customerSalarySeq");
				String fee=res.getString("fee");
				String bankstatus = res.getString("bankstatus");
				//String ewpCheckcode=res.getString("ewpCheckcode");
				//String ewpSequence=res.getString("ewpSquence");
				//String errorreason=res.getString("errorreason");

				singleRecord.put("customerSalarySeq",refundno);
				singleRecord.put("fee",fee);

				String state = "refunding"; //转账中
				if ("6".equals(bankstatus) || "B".equals(bankstatus)) {
					state = "refund";//转账、退款成功
					flag = flag & 1; //一直为1时才输出1
					String ewpSequence = res.getString("ewpSequence");
					singleRecord.put("ewpSequence", ewpSequence);
					singleRecord.put("errorreason","");
				}else if ("7".equals(bankstatus) || "C".equals(bankstatus) || "9".equals(bankstatus)) {
					state = "failed";//转账失败
					flag = flag & 0;
					String errorreason = res.getString("errorreason");
					singleRecord.put("errorreason", errorreason);
					singleRecord.put("ewpSequence", "");
				}else{
					flag = flag & 0;
				}
				singleRecord.put("state", state);
				recordsForSingleBatch.add(singleRecord);
			}
			//没有全部转账 就是flag为0
			*//*String errorcode = "1";
			if (flag == 1) {
				errorcode = "0";
			}*//*
			//新逻辑是只要有数据，就把这一批子流水的errorcode置为0
			String errorcode="0";
			result.put("errorcode", errorcode);
			result.put("records",recordsForSingleBatch);
			return result;
		}else {
			logger.info("批量转账交易结果查询出错, 错误码为:"+ retCode );

			*//*result.put("customerBatchNo","");
			result.put("accountNo","");
			result.put("allCount",null);
			result.put("allSalary",null);
			result.put("allHandlefee",null);
			result.put("count",null);
			result.put("errorCount",null);
			result.put("unknowCpunt",null);

			result.put("records",null);*//*

			//这一批没查出数据的话，查询出错的话就把这一批的error置为1
			result.put("errorcode", "1");
			result.put("errortext", "转账查询出错, 错误码为:"+ retCode);
			return result;
		}*/
	}


	/**
	 * 方法简介 :拼接批量转账交易结果查询接口（0034）需要的xml格式参数
	 * @Title: transDetailsXml0034
	 * @author:  L_Y
	 * @date:   2020年9月23日16:22:10
	 */
	private String transDetailsXml0034(String para) {
		String batchno = para;
		//String entseqno = para.getString("entseqno");
//		String refundno = para.getString("refundno", "");
		String cifMaster = "1000196335";
		String entUserId = "100001";
		String password = "1q2w3e4r";

		// 创建一个Document实例
		Document doc = DocumentHelper.createDocument();
		doc.setXMLEncoding("GBK");	//默认utf-8
		// 添加根节点
		Element BEDC = doc.addElement("BEDC");
		Element Message = BEDC.addElement("Message");
		Element commHead = Message.addElement("commHead");
		commHead.addElement("tranCode")
				.addText("0034");
		commHead.addElement("cifMaster")
				.addText(cifMaster);//网银客户号
		commHead.addElement("entSeqNo")
				.addText(batchno);//batchno就是entSeqNo
		commHead.addElement("tranDate")
				.addText(DateUtil.getCurrentDateToString("yyyyMMdd"));//日期
		commHead.addElement("tranTime")
				.addText(DateUtil.getCurrentDateToString("HH:mm:ss"));//时间
		commHead.addElement("retCode")
				.addText("");//返回码
		commHead.addElement("entUserId")
				.addText(entUserId);//操作员
		commHead.addElement("password")
				.addCDATA(password);//操作密码

		Element Body = Message.addElement("Body");
		Body.addElement("customerBatchNo").addText(batchno);//客户批次号
		//只用批次号去查，一个批次号对应多笔子流水
		/*if (!StringUtils.isEmpty(refundno)) {
			Body.addElement("customerSalarySeq")
					.addText(refundno);//客户批次子流水号  选输
		}*/

		return doc.asXML();
	}

}
