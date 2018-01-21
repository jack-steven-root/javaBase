/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.mutilThread;

/**
 * @author root
 *
 */
public class TestMutilThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable myRunnable = new MyRunnable();
		Thread a = new Thread(myRunnable, "a");
		Thread b = new Thread(myRunnable, "b");
		Thread c = new Thread(myRunnable, "c");
		myRunnable.stop();
		Thread d = new Thread(myRunnable, "d");
		Thread e = new Thread(myRunnable, "e");
		Thread f = new Thread(myRunnable, "f");

		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		f.start();

		// a.stop();
		System.out.println(a.getState());
		b.start();
		// b.start();
		c.start();
		d.start();
		e.start();
		f.start();

	}

}
