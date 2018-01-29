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
public class Exercise21_3 {
	public static void main(String[] args) {
		Exercise21_3 exer = new Exercise21_3();
		exer.useFixedThreadPool();
		exer.useNewCachedThreadPool();
		exer.useSingleThreadPool();
	}

	public void useNewCachedThreadPool() {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Fibonaccil(50));
		}
		exec.shutdown();
	}

	public void useFixedThreadPool() {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			exec.execute(new Fibonaccil(50));
		}
		exec.shutdown();
	}

	public void useSingleThreadPool() {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 500; i++) {
			exec.execute(new Fibonaccil(50));
		}
		exec.shutdown();
	}
}
