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
public class CatsAndDogs2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector cats = new Vector();
		for (int i = 0; i < 7; i++) {
			cats.addElement(new Cat2(i));
		}
		cats.addElement(new Dog2(7));
		Enumeration e = cats.elements();
		while (e.hasMoreElements())
			((Cat) e.nextElement()).print();
	}

}

class Cat2 {
	private int catNumber;

	Cat2(int i) {
		catNumber = i;
	}

	void print() {
		System.out.println("Cat number " + catNumber);
	}
}

class Dog2 {
	private int dogNumber;

	Dog2(int i) {
		dogNumber = i;
	}

	void print() {
		System.out.println("Dog number " + dogNumber);
	}
}
