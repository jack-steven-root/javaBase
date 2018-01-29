/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class Bank {
	private final double[] accounts;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
	}

	public synchronized void transfer(int from, int to, double amount) {
		try {
			while (accounts[from] < amount) {
				wait();
			}
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("10.2f from %d to %d", amount, from, to);
			notifyAll();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public 
}
