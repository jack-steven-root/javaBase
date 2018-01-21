/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Music2 {
	public static void tune(Wind2 i) {
		i.play(Note.middleC);
	}

	public static void tune(Stringed2 i) {
		i.play(Note.middleC);
	}

	public static void tune(Brass2 i) {
		i.play(Note.middleC);
	}

	public static void main(String[] args) {
		Wind2 flute = new Wind2();
		Stringed2 violin = new Stringed2();
		Brass2 frenchHorn = new Brass2();

		tune(flute);
		tune(violin);
		tune(frenchHorn);
	}

}

class Note2 {
	private int value;

	private Note2(int val) {
		value = val;
	}

	private static final Note2 middleC = new Note2(0), cSharp = new Note2(1), cFlat = new Note2(2);
}

class Instrument2 {
	public void play(Note n) {
		System.out.println("Instrument2.play()");
	}
}

class Wind2 extends Instrument2 {
	@Override
	public void play(Note n) {
		System.out.println("Wind.play()");
	}
}

class Stringed2 extends Instrument2 {
	@Override
	public void play(Note n) {
		System.out.println("Stringed.play()");
	}
}

class Brass2 extends Instrument2 {
	@Override
	public void play(Note n) {
		System.out.println("Brass.play()");
	}
}