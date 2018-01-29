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
public class DeadLock extends Thread
{
	A a = new A();
	B b = new B();

	public void init()
	{
		Thread.currentThread().setName("主线程");
		a.foo(b);
		System.out.println("进入了主线程之后");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DeadLock dl = new DeadLock();
		// 以dl为target启动新线程
		new Thread(dl).start();
		dl.init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		Thread.currentThread().setName("副线程");
		// 调用b对象的bar()方法
		b.bar(a);
		System.out.println("进入了线程之后");
	}
}

class A
{
	public synchronized void foo(B b)
	{
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "进入了A实例的foo()方法");
		try
		{
			Thread.sleep(200);
		} catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "企图调用Bs实例的last()方法");
		b.last();
	}

	public synchronized void last()
	{
		System.out.println("进入了A类的last()方法内部");
	}
}

class B
{
	public synchronized void bar(A a)
	{

		System.out.println("当前线程名:" + Thread.currentThread().getName() + "进入了B实例的bar()方法");

		try
		{
			TimeUnit.SECONDS.sleep(200);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("当前线程名:" + Thread.currentThread().getName() + "企图调用A实例的last()方法");
		a.last();
	}

	public synchronized void last()
	{
		System.out.println("进入了B类的last()方法内部");
	}

}
