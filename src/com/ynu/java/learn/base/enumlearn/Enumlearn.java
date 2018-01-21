/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.enumlearn;

/**
 * @author root
 *
 */

public class Enumlearn {
	private static double salary;
	private static final String DEPARTMENT = "开发人员";

	public static void main(String[] args) {
		FreshJuice juice = new FreshJuice();
		juice.size = FreshJuice.FreshJuiceSize.LARGE;
		System.out.println(juice.size);

		salary = 1000000;
		System.out.println(DEPARTMENT + "平均工资:" + salary);
		salary = 10000;
		System.out.println(DEPARTMENT + "平均工资:" + salary);
	}
}

class FreshJuice {
	enum FreshJuiceSize {
		SMALL, MEDIUM, LARGE
	}

	FreshJuiceSize size;
}
