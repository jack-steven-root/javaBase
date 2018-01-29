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
public class Exercise21_4 {

	public static void main(String[] args) {
		Exercise21_4 exer = new Exercise21_4();
		exer.useCacheThreadPool();
		exer.useFixedThreadPool();
		exer.useSingleThreadPool();
	}

	public void useFixedThreadPool() {
		ExecutorService exec = Executors.newFixedThreadPool(12);
		for (int i = 0; i < 5; i++) {
			exec.execute(new implementMulti());
		}
		exec.shutdown();
	}

	public void useCacheThreadPool() {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new implementMulti());
		}
		exec.shutdown();
	}

	public void useSingleThreadPool() {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec.execute(new implementMulti());
		}
		exec.shutdown();
	}
}
