/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

import java.util.Vector;

/**
 * @author root
 *
 */
public class CrashJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v = new Vector();
		for (int i = 0; i < 10; i++) {
			v.addElement(new CrashJava());
		}
		System.out.println(v);
	}

	@Override
	public String toString() {
		return "CrashJava address: " + super.toString() + "\n";
	}
}
