package com.wdf.test.javabasic.String;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalTest {
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#0.00");
		System.out.println(df.format(new BigDecimal(0)));
	}

}
