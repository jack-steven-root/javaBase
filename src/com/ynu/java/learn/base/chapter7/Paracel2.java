/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Paracel2 {
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

	public Destination to(String s) {
		return new Destination(s);
	}

	public Contents cont() {
		return new Contents();
	}

	public void ship(String dest) {
		Contents c = cont();
		Destination d = to(dest);
	}

	public static void main(String[] args) {
		Paracel2 p = new Paracel2();
		p.ship("Tanzania");
		Paracel2 q = new Paracel2();
		Paracel2.Contents c = q.cont();
		Paracel2.Destination d = q.to("Borneo");
	}
}
