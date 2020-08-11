package com.wdf.test.javabasic.jicheng;

public class EExtendsD extends DFinal{
	public void test() {
		
		System.out.println(this.name +this.id);
		System.out.println(super.id +super.name);
		
		//相同名称的方法，super和this会调用不同的类里面
		super.test1();
		this.test1();
	}
	
	public void test1() {
		// TODO Auto-generated method stub
		System.out.println("Son");
	}
}
