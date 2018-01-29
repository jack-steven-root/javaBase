/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author root
 *
 */
public class DaemonFromFactory implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.print(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Interrupted ");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 10; i++) {
			exec.execute(new DaemonFromFactory());
		}
		System.out.print("All daemons started");
		TimeUnit.MILLISECONDS.sleep(500);
	}

}
