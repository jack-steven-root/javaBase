/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public final class Month2 {
	private String name;

	private Month2(String nm) {
		name = nm;
	}

	@Override
	public String toString() {
		return name;
	}

	public final static Month2 JAN = new Month2("January"), FEB = new Month2("February"), MARCH = new Month2("March"),
			APRIL = new Month2("April"), MAY = new Month2("May"), JUNE = new Month2("June"), JULY = new Month2("July"),
			AUGUST = new Month2("August"), SEPTEMBER = new Month2("September"), OCTOBER = new Month2("October"),
			NOVEMBER = new Month2("November"), DECEMBER = new Month2("December");
	public final static Month2[] month = { JAN, JAN, FEB, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER,
			NOVEMBER, DECEMBER };

	public static void main(String[] args) {
		Month2 m = Month2.JAN;
		System.out.println(m);
		m = Month2.month[12];
		System.out.println(m);
		System.out.println(m == Month2.DECEMBER);
		System.out.println(m.equals(Month2.DECEMBER));
	}

}
