/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author root
 *
 */
public class Exercise21_9 implements Runnable {
	private int countDown = 5;
	private volatile double d; // No optimization
	private int priority;

	public Exercise21_9(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return Thread.currentThread() + ": " + countDown + "Priority is  " + Thread.currentThread().getPriority();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(priority);
		while (true) {
			// An expensive,interruptable operation:
			for (int i = 1; i < 100000; i++) {
				d += (Math.PI + Math.E) / i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new defaultThreadFactory(Thread.MIN_PRIORITY));
		for (int i = 0; i < 5; i++) {
			exec.execute(new Exercise21_9(Thread.MIN_PRIORITY));
			exec.execute(new Exercise21_9(Thread.MAX_PRIORITY));
		}
		exec.shutdown();
	}

}

class defaultThreadFactory implements ThreadFactory {

	private int priorities;

	/**
	 * @param priorities
	 */
	public defaultThreadFactory(int priorities) {
		this.priorities = priorities;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread currentThread = new Thread(r);
		currentThread.setPriority(priorities);
		return currentThread;
	}

}
