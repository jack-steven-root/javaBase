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
public class GopherVector {
	private Vector v = new Vector();

	public void addElement(Gopher m) {
		v.addElement(m);
	}

	public Gopher elementAt(int index) {
		return (Gopher) v.elementAt(index);
	}

	public int size() {
		return v.size();
	}

	public static void main(String[] args) {
		GopherVector gophers = new GopherVector();
		for (int i = 0; i < 3; i++) {
			gophers.addElement(new Gopher(i));
		}
		for (int i = 0; i < gophers.size(); i++) {
			GopherTrap.caughtYa(gophers.elementAt(i));
		}
	}
}

class Gopher {
	private int gopherNumber;

	Gopher(int i) {
		gopherNumber = i;
	}

	void print(String msg) {
		if (msg != null) {
			System.out.println("Gopher number " + gopherNumber);
		}
	}
}

class GopherTrap {
	static void caughtYa(Gopher g) {
		g.print("Caught one !");
	}
}