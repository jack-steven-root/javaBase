/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcell1 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}

	}

	class Destination {
		private String label;

		Destination(String whereTo) {
			label = whereTo;
		}

		String readLabel() {
			return label;
		}
	}

	public void ship(String dest) {
		Contents c = new Contents();
		Destination d = new Destination(dest);
	}

	public static void main(String[] args) {
		Parcell1 p = new Parcell1();
		p.ship("Tanzania");
	}

}
