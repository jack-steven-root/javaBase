/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Music5 {
	// Doesn't care about type,so new types
	// added to the system still work right
	static void tune(Instrument5 i) {
		i.play();
	}

	static void tuneAll(Instrument5[] e) {
		for (int i = 0; i < e.length; i++) {
			tune(e[i]);
		}
	}

	public static void main(String[] args) {
		Instrument5[] orchestra = new Instrument5[5];
		int i = 0;
		// Upcasting during addition to the array
		orchestra[i++] = new Wind5();
		orchestra[i++] = new Percussion5();
		orchestra[i++] = new Stringed5();
		orchestra[i++] = new Brass5();
		orchestra[i++] = new Woodwind5();

		tuneAll(orchestra);
	}
}

interface Instrument5 {
	// Compile-time constant:
	int i = 5;

	// Cannot have method definitions
	void play(); // Automatically public

	String what();

	void adjust();
}

class Wind5 implements Instrument5 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Wind5.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Wind5";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Percussion5 implements Instrument5 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Percussion5.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Percussion5";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Stringed5 implements Instrument5 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Stringed5.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Stringed5";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument5#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Brass5 extends Wind5 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind5#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Brass5.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind5#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub
		System.out.println("Brass5.adjust()");
	}

}

class Woodwind5 extends Wind5 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind5#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Woodwind5.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind5#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Woodwind5";
	}

}
