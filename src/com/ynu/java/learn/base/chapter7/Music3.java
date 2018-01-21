/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
class Instrument3 {
	public void play() {
		System.out.println("Instrument3.play()");
	}

	public String what() {
		return "Instrument3";
	}

	public void adjust() {
	}
}

class Wind3 extends Instrument3 {
	@Override
	public void play() {
		System.out.println("wind3.play()");
	}

	@Override
	public String what() {
		return "Wind3";
	}

	@Override
	public void adjust() {
	}
}

class Percussion3 extends Instrument3 {
	@Override
	public void play() {
		System.out.println("Percussion3.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument3#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Percussion3";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument3#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub
	}

}

class Stringed3 extends Instrument3 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument3#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Stringed3.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument3#what()
	 */
	@Override
	public String what() {
		// TODO Auto-generated method stub
		return "Stringed3";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Instrument3#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub

	}

}

class Brass3 extends Wind3 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind3#adjust()
	 */
	@Override
	public void adjust() {
		// TODO Auto-generated method stub
		System.out.println("Brass3.adjust()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind3#play()
	 */
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Brass3.play()");
	}

}

class Woodwind3 extends Wind3 {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind3#play()
	 */
	@Override // 表示覆盖
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Woodwind3.play()");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Wind3#what()
	 */
	public String what(String test) {
		// TODO Auto-generated method stub
		return "Woodwind3";
	}

}

public class Music3 {
	static void tune(Instrument3 i) {
		i.play();
	}

	static void tuneAll(Instrument3[] e) {
		for (int i = 0; i < e.length; i++) {
			tune(e[i]);
		}
	}

	public static void main(String[] args) {
		Instrument3[] orchestra = new Instrument3[5];
		int i = 0;
		// Upcasting during addition to the array
		orchestra[i++] = new Wind3();
		orchestra[i++] = new Percussion3();
		orchestra[i++] = new Stringed3();
		orchestra[i++] = new Brass3();
		orchestra[i++] = new Woodwind3();
		tuneAll(orchestra);

	}

}