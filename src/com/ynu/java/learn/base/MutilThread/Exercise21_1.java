/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class Exercise21_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			new Thread(new implementMulti()).start();
		}
		System.out.println("Thread task is shutdown !");
	}

}

class implementMulti implements Runnable {
	/**
	 * 
	 */
	public implementMulti() {
		// TODO Auto-generated constructor stub
		System.out.println(Thread.currentThread().getName() + " is starting ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " is running ");
		}
	}

}
