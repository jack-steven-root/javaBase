/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Shapes {
	public static Shape randShape() {
		switch ((int) (Math.random() * 3)) {
		default: // To quiet the compiler
		case 0:
			return new Circle();
		case 1:
			return new Square();
		case 2:
			return new Triangle();
		}
	}

	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		// Fill up the array with shapes:
		for (int i = 0; i < s.length; i++) {
			s[i] = randShape();
		}
		for (int i = 0; i < s.length; i++) {
			s[i].draw();
		}
	}

}

class Shape {
	void draw() {
	}

	void erase() {
	}
}

class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("Circle.draw()");
	}

	@Override
	void erase() {
		System.out.println("Circle.erase()");
	}
}

class Square extends Shape {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Shape#draw()
	 */
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("Square.draw()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Shape#erase()
	 */
	@Override
	void erase() {
		// TODO Auto-generated method stub
		System.out.println("Square.erase()");
	}
}

class Triangle extends Shape {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Shape#draw()
	 */
	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("Triangle.draw()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Shape#erase()
	 */
	@Override
	void erase() {
		// TODO Auto-generated method stub
		System.out.println("Triangle.erase()");
	}

}
