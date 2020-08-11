package com.wdf.test.javabasic.duotai;

import org.apache.ibatis.javassist.compiler.ast.NewExpr;

/**
 * 
 * @Package: com.wdf.test.javabasic.duotai
 * @ClassName: GuaHaoTest
 * @Description: 挂号多态
 * @author: WDF
 * @date: 2020年8月11日 上午9:30:05
 * @version: V1.0
 */
public class GuaHaoTest {

	public static void main(String[] args) {
		GuaHaoTest g = new GuaHaoTest();
		
		//嘴科
		MouseDet mDet = new MouseDet();
		mDet.name = "嘴科";
		//头科
		HeadDet hDet = new HeadDet();
		hDet.name = "头科";
		
		Patient patient = new Patient();
		patient.name = "Tina";
		
		g.register(mDet, patient);
		
	}
	
	public void register(DepartMent departMent, Patient patient) {
		System.out.println("挂号：" + patient.name);
		departMent.treament(patient);
	}
}

// 部门的父类
class DepartMent{
	public String name;
	
	public void treament(Patient patient) {
		System.out.println("接诊中...  DepartMent开始治疗");
	}
}

// 病人的类
class Patient{
	public String name;
}

class MouseDet extends DepartMent{
	
	public void treament(Patient patient) {
		System.out.println("口腔治疗中...  MouseDet治疗");
	}
}

class HeadDet extends DepartMent{
	
	public void treament(Patient patient) {
		System.out.println("头疼治疗中...  HeadDet治疗");
	}
}
