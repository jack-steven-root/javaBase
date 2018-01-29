/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class Exercise21_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			new Thread(new Fibonaccil(300000)).start();
		}
	}

}

class Fibonaccil implements Runnable {
	private int number;

	/**
	 * @param number
	 */
	public Fibonaccil(int number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int a = 1, b = 1, c = 0;
		System.out.println("斐波那契数列前" + number + "项");
		System.out.println(a + "\t" + b + "\t");
		for (int i = 1; i <= number; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + "\t");
			if ((i + 2) % 5 == 0)
				System.out.println();
		}
	}

}
