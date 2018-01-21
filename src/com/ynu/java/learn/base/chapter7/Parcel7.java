/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcel7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel7 p = new Parcel7();
		Wrapping w = p.wrap(7);
	}

	public Wrapping wrap(int x) {
		// Base constructor call:
		return new Wrapping(x) {
			@Override
			public int value() {
				return super.value() * 47;
			}
		};
	}

}

class Wrapping {
	private int i = 11;

	/**
	 * @param x
	 */
	public Wrapping(int x) {
		// TODO Auto-generated constructor stub
		i = x;
	}

	public int value() {
		return i;
	}
}
