/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class PolyConstructors {

	public static void main(String[] args) {
		new RoundGlyph(5);
	}
}

class RoundGlyph extends Glyph {
	int radius = 1;

	/**
	 * @param radius
	 */
	public RoundGlyph(int radius) {

		this.radius = radius;
		System.out.println("RoundGlyph.RoundGlyph(),radius= " + radius);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Glyph#draw()
	 */
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("RoundGlyph.draw(), radius =" + radius);
	}

}

abstract class Glyph {
	abstract void draw();

	Glyph() {
		System.out.println("Glyph() before draw() ");
		draw();
		System.out.println("Glyph() after draw() ");
	}
}
