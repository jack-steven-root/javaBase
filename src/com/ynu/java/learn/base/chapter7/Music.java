/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Music {
	public static void tune(Instrument i) {
		i.play(Note.middleC);
	}

	public static void main(String[] args) {
		Wind flute = new Wind();
		tune(flute); // Upcasting
	}

}

class Note {
	private int value;

	private Note(int val) {
		value = val;
	}

	public static final Note middleC = new Note(0), cSharp = new Note(1), cFlat = new Note(2);
}

class Instrument {
	public void play(Note n) {
		System.out.println("Instrument.play()");
	}
}

class Wind extends Instrument {
	@Override
	public void play(Note n) {
		System.out.println("Wind.play()");
	}
}
