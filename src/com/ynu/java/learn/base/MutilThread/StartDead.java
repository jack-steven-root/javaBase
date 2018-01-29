/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root 不要对处于死亡状态的线程调用start()方法,程序只能对新建状态的线程调用start()方法
 *         对新建状态的线程两次调用start()方法也是错误的。这都会引发IllegalTreadStateException异常
 */
public class StartDead extends Thread
{
	private int i;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (; i < 100; i++)
		{
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args)
	{
		// 创建线程对象
		StartDead sd = new StartDead();
		for (int i = 0; i < 300; i++)
		{
			// 调用Thread的currentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20)
			{
				// 启动线程
				sd.start();
				// 判断启动后线程的isAlive()值,输出true
				System.out.println(sd.isAlive());
			}
			// 当线程处于新建、死亡两种状态时,isAlive()方法发返回false
			// 当i>20时,该线程肯定已经启动过了,如果sd.isAlive()为假时
			// 那就是死亡状态了
			if (i > 20 && !sd.isAlive())
			{
				// 试图再次启动该线程
				sd.start();
			}
		}
	}

}
