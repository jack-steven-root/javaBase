/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.TimeUnit;

/**
 * @author root
 *
 */
public class DrawThread_1 extends Thread
{
	// 模拟账户
	private Account account;
	private double drawAmount;

	public DrawThread_1(String name, Account account, double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	// 当多个线程修改同一个共享数据时,将涉及数据安全的设置
	@Override
	public void run()
	{
		// 使用account作为同步监视器,任何线程进入下面同步代码块之前
		// 必须先获得对account账户的锁定--其他线程无法获得锁,也就无法修改它
		// 这种做法符合:"加锁->修改->释放锁"的逻辑
		synchronized (account)
		{
			// 账户余额大于取钱数目
			if (account.getBalance() >= drawAmount)
			{
				// 吐出钞票
				System.out.println(getName() + "取钱成功!吐出钞票:" + drawAmount);
				try
				{
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				// 修改余额
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("\t余额为:" + account.getBalance());
			} else
			{
				System.out.println(getName() + "取钱失败!余额不足!");
			}

		}
	}
}
