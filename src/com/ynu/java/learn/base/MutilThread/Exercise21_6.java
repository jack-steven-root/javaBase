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
import java.util.concurrent.TimeUnit;

/**
 * @author root
 *
 */
public class Exercise21_6 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		LinkedList<Future<String>> runResult = new LinkedList<Future<String>>();
		for (int i = 0; i < 50; i++) {
			runResult.add(exec.submit(new testCallable()));
		}

		for (Future<String> fs : runResult) {
			try {
				System.out.println("Future<String> is Done " + fs.isDone() + "  the run result is " + fs.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}

}

class testCallable implements Callable<String> {
	private boolean startFlag = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		while (startFlag) {
			System.out.println("开始休眠任务!");
			long a = (long) (Math.random() * 500);
			TimeUnit.MILLISECONDS.sleep(a);
			System.out.println("休眠的时间: " + a);
			startFlag = false;
			return a + "";
		}
		return null;
	}

}
