/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Sandwich extends PortableLunch {
	Bread b = new Bread();
	Cheese c = new Cheese();

	Sandwich() {
		System.out.println("Sandwich()");
	}

	public static void main(String[] args) {
		new Sandwich();
	}
}

class Meal {
	private int i = 5;
	private Bread bread = new Bread();

	Meal() {
		System.out.println("Meal()  ****" + i);
	}
}

class Bread {
	Bread() {
		System.out.println("Bread()");
	}
}

class Cheese {
	Cheese() {
		System.out.println("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		System.out.println("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		System.out.println("Lunch");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		System.out.println("ProtableLunch()");
	}
}
