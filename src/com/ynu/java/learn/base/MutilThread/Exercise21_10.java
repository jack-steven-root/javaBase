/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author root
 *
 */
public class Exercise21_10 {

	private int countDown = 5;
	private Thread t;
	private String name;

	public Exercise21_10(String name) {
		this.name = name;
	}

	public void runTask(int n) {
		ExecutorService exec = Executors.newCachedThreadPool();// 工头
		ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();//
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskCallable(n)));
		}

	}

	public static void main(String[] args) {
		new Exercise21_10(Thread.currentThread().getName()).runTask(10);

	}

}

class TaskCallable implements Callable<Integer> {
	private int number;

	/**
	 * 
	 */
	public TaskCallable(int number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
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