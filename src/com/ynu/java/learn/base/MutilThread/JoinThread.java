/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class JoinThread extends Thread
{
	// 提供一个有参数的构造器,用于设置该线程的名字
	public JoinThread(String name)
	{
		super(name);
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
		for (int i = 0; i < 100; i++)
		{
			System.out.println(getName() + " " + i);
		}
		super.run();
	}

	public static void main(String[] args) throws Exception
	{
		new JoinThread("新线程").start();
		for (int i = 0; i < 100; i++)
		{
			if (i == 20)
			{
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				// main线程调用了jt线程的join()方法,main线程
				// 必须等jt执行结束才会向下执行
				jt.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}
