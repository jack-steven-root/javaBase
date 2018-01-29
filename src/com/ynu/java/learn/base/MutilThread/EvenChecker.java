/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author root
 *
 */
public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator g, int ident) {
		generator = g;
		id = ident;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + "not even!");
				generator.cancel(); // Cancels all EventCheckers
			}
		}
	}

	// Test any type of IntGenerator
	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Control-c to exit ");
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			exec.execute(new EvenChecker(gp, i));
		}
		exec.shutdown();
	}

	// Deafault value for count
	public static void test(IntGenerator gp) {
		test(gp, 10);
	}

}
