/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class Account
{
	// 封装账户编号,账户余额的两个成员变量
	private String accountNo;
	private double balance;

	public Account()
	{
	}

	// 构造器
	public Account(String accountNo, double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo()
	{
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}

	/**
	 * @return the balance
	 */
	public double getBalance()
	{
		return balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	// 提供一个线程安全的draw()方法来完成取钱操作
	public synchronized void draw(double drawAmount)
	{
		// 账户余额大于取钱数目
		if (balance >= drawAmount)
		{
			// 吐出钞票
			System.out.println(Thread.currentThread().getName() + "取钱成功!吐出钞票:" + drawAmount);
			try
			{
				Thread.sleep(1);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			// 修改余额
			balance -= drawAmount;
			System.out.println("\t余额为: " + balance);
		} else
		{
			System.out.println(Thread.currentThread().getName() + "取钱失败!余额不足! ");
		}
	}
}
