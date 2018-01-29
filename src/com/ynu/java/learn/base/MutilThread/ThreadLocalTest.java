/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root 通常的建议:如果多个线程之间需要共享资源，以达到线程之间的通信功能,就使用同步机制;如果仅仅需要隔离多个线程
 *         之间的共享冲突,则可以使用ThreadLocal.
 */
public class ThreadLocalTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 启动两个线程,两个线程共享一个Account
		Account_2 at = new Account_2("初始名");
		new MyTest(at, "线程甲").start();
		new MyTest(at, "线程乙").start();
	}

}

class Account_2
{
	// 定义一个ThreadLocal类型的变量,该变量将是一个线程局部变量
	// 每个线程都会保留该变量的一个副本
	private ThreadLocal<String> name = new ThreadLocal<>();

	// 定义一个初始化name成员变量的构造器
	public Account_2(String str)
	{
		this.name.set(str);
		// 下面代码用于访问当前线程的name副本的值
		System.out.println("---" + this.name.get());
	}

	// name的setter和getter方法
	public String getName()
	{
		return this.name.get();
	}

	public void setName(String str)
	{
		this.name.set(str);
	}
}

class MyTest extends Thread
{
	// 定义一个Account类型的成员变量
	private Account_2 account;

	MyTest(Account_2 account, String name)
	{
		super(name);
		this.account = account;
	}

	@Override
	public void run()
	{
		// 循环10次
		for (int i = 0; i < 10; i++)
		{
			// 当i==6时输出将账户名替换成当前线程名
			if (i == 6)
			{
				account.setName(getName());
			}
			// 输出同一个账户的账户名和循环变量
			System.out.println(account.getName() + " 账户的i值:" + i);
		}
	}
}
