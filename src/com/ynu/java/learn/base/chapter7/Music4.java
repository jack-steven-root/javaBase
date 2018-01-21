/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Music4 {
	// Doesn't care about type,so new types
	// added to the system still work right
	static void tune(Instrument4 i) {
		i.play();
	}

	static void tuneAll(Instrument4[] e) {
		for (int i = 0; i < e.length; i++) {
			tune(e[i]);
		}
	}

	public static void main(String[] args) {
		Instrument4[] orchestra = new Instrument4[5];
		int i = 0;
		// Upcasting during addition to the array:
		orchestra[i++] = new Wind4();
		orchestra[i++] = new Percussion4();
		orchestra[i++] = new Stringed4();
		orchestra[i++] = new Brass4();
		orchestra[i++] = new Woodwind4();

		tuneAll(orchestra);
	}
}

abstract class Instrument4 {
	int i; // storage allocated for each

	public abstract void play();

	public String what() {
		return "Instrument4";
	}

	public abstract void adjust();
}

class Wind4 extends Instrument4 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument4#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Wind4.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument4#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

	@Override
	public String what() {
		return "Wind4";
	}

}

class Percussion4 extends Instrument4 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument4#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Percussion4.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument4#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Stringed4 extends Instrument4 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument4#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Stringed4.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument4#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Brass4 extends Wind4 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind4#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Brass4.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind4#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub
		System.out.println("Brass4.adjust()");
	}

}

class Woodwind4 extends Wind4 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind4#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Woodwind4.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind4#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Woodwind4";
	}

}