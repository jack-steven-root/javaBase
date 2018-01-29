/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class Exercise21_8 extends Thread {
	private int countDown = 5;
	private static int threadCount = 0;

	public Exercise21_8() {
		// store the thread name
		super(Integer.toString(++threadCount));
		this.setDaemon(true);
		start();
	}

	@Override
	public String toString() {
		return "#" + getName() + "(" + countDown + ").";
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SimpleThread();
		}
	}
}
