/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class SelfManaged implements Runnable {
	private int countDown = 5;
	private Thread t = new Thread(this);

	public SelfManaged() {
		t.start();
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + "(" + countDown + "), ";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.print(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			new SelfManaged();
	}
}
