/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

import java.util.ArrayList;

/**
 * @author root
 *
 */
public class ApplesAndOrangesWithoutGenerics {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
			apples.add(new Orange());
			for (int i = 0; i < apples.size(); i++) {
				((Apple) apples.get(i)).id();
			}
		}
	}

}

class Apple {
	private static long counter;
	private final long id = counter++;

	public long id() {
		return id;
	}
}

class Orange {
}
