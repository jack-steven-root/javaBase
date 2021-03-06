/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 *
 */
public class Account_1
{
	// 定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	// 封装账户编号、账户余额的两个成员变量
	private String accountNo;
	private double balance;

	public Account_1()
	{
	}

	// 构造器
	public Account_1(String accountNo, double balance)
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

	// 因为账户余额不允许随便修改,所以只为balance提供getter方法
	public double getBalance()
	{
		return this.balance;
	}

	// 提供一个线程安全的draw()方法来完成取钱操作
	public void draw(double drawAmount)
	{
		// 加锁
		lock.lock();
		try
		{
			// 账户余额大于取钱数目
			if (balance >= drawAmount)
			{
				// 吐出钞票
				System.out.println(Thread.currentThread().getName() + "取钱成功!吐出钞票:" + drawAmount);

				try
				{
					Thread.sleep(1);
				} catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				// 修改余额
				balance -= drawAmount;
				System.out.println("\t余额为:" + balance);
			} else
			{
				System.out.println(Thread.currentThread().getName() + "取钱失败!余额不足!");
			}
		} finally
		{
			// 修改完成,释放锁
			lock.unlock();
		}
	}
}
