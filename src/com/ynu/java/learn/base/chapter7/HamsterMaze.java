/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author root
 *
 */
public class HamsterMaze {
	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i = 0; i < 3; i++) {
			v.addElement(new Hamster(i));
		}
		Printer.printAll(v.elements());
	}
}

class Hamster {
	private int hamsterNumber;

	Hamster(int i) {
		hamsterNumber = i;
	}

	@Override
	public String toString() {
		return "This is Hamster " + hamsterNumber;
	}
}

class Printer {
	static void printAll(Enumeration e) {
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement().toString());
		}
	}
}
