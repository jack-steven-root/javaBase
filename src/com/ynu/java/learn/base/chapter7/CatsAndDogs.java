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
public class CatsAndDogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector cats = new Vector();

		for (int i = 0; i < 7; i++) {
			cats.addElement(new Cat(i));
		}
		cats.addElement(new Dog(7));
		for (int i = 0; i < cats.size(); i++) {
			((Dog) cats.elementAt(i)).print();
		}
	}

}

class Cat {
	private int catNumber;

	Cat(int i) {
		catNumber = i;
	}

	void print() {
		System.out.println("Cat #" + catNumber);
	}
}

class Dog {
	private int dogNumber;

	Dog(int i) {
		dogNumber = i;
	}

	void print() {
		System.out.println("Dog #" + dogNumber);
	}
}
