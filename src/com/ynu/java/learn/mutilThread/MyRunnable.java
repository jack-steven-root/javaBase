/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.mutilThread;

/**
 * @author root
 *
 */
public class MyRunnable implements Runnable {
	private volatile boolean active;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		active = true;
		for (int i = 0; i < 100000000 && active; i++) {
			System.out
					.println("mutilply thread is run by " + Thread.currentThread().getName() + "  active is " + active);
		}
	}

	public void stop() {
		active = false;
	}

}
