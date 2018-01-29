/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author root
 *
 */
public class Exercise21_5 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(50);
		LinkedList<Future<Integer>> runResults = new LinkedList<Future<Integer>>();
		for (int i = 0; i < 100; i++) {
			runResults.add(exec.submit(new Fibonaccil1(i)));
		}
		for (Future<Integer> fs : runResults) {
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				System.out.println(e);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}
}

class Fibonaccil1 implements Callable<Integer> {
	private int number;

	/**
	 * @param number
	 */
	public Fibonaccil1(int number) {
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() {
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
		return c;
	}

}
