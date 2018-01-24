/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class ArraySize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weeble[] a; // null handle
		Weeble[] b = new Weeble[5]; // Null handles
		Weeble[] c = new Weeble[4];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Weeble();
		}
		Weeble[] d = { new Weeble(), new Weeble(), new Weeble() };

	}

}

class Weeble {

}
