/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
class MyThread extends Thread
{

	/**
	 * @param name
	 */
	public MyThread(String name)
	{
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param group
	 * @param name
	 */
	public MyThread(ThreadGroup group, String name)
	{
		super(group, name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

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
		for (int i = 0; i < 20; i++)
		{
			System.out.println(getName() + "线程的i变量" + i);
		}
	}

}

public class ThreadGroupTest
{
	public static void main(String[] args)
	{
		// 获取主线程所在的线程组,这是所有默认的线程组
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("主线程组的名字:" + mainGroup.getName());
		System.out.println("主线程是否是后台线程组:" + mainGroup.isDaemon());

		new MyThread("主线程组的线程").start();

		ThreadGroup tg = new ThreadGroup("新线程组");
		tg.setDaemon(true);
		System.out.println("tg线程组是否是后台线程组:" + tg.isDaemon());

		MyThread tt = new MyThread(tg, "tg组的线程甲");
		tt.start();
		new MyThread(tg, "tg组的线程乙");
	}
}
