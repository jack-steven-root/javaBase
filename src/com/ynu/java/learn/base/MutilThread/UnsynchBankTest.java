/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 *
 */
public class UnsynchBankTest {
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}

class Bank {
	private final double[] accounts;
	private Lock bankLock = new ReentrantLock();
	private Condition sufficientFunds;

	public Bank(int n, double initialBalance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		sufficientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount)
			return;
		bankLock.lock();
		try {
			while (accounts[from] < amount)
				sufficientFunds.await();
			System.out.print(Thread.currentThread());
			accounts[to] += amount;
			System.out.printf("%10.2f from %d to %d \n", amount, from, to);
			accounts[from] -= amount;
			System.out.printf("Total Balance: %10.2f %n \n", getTotalBalance());
			sufficientFunds.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bankLock.unlock();
		}
	}

	public double getTotalBalance() {
		double sum = 0;
		for (double a : accounts)
			sum += a;
		return sum;
	}

	public int size() {
		return accounts.length;
	}
}

class TransferRunnable implements Runnable {

	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 1;

	public TransferRunnable(Bank b, int from, double max) {
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			int toAccount = (int) (bank.size() * Math.random());
			double amount = maxAmount * Math.random();
			bank.transfer(fromAccount, toAccount, amount);
			try {
				Thread.sleep((int) (DELAY * Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
