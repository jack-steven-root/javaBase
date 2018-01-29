/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author root
 *
 */
public class BlockingQueueTest2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 创建一个容量为1的BlockingQueue
		BlockingQueue<String> bq = new LinkedBlockingQueue<String>(1);
		// 启动3个生产线程
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		// 启动一个消费者线程
		new Consumer(bq).start();
	}
}

class Producer extends Thread
{
	private BlockingQueue<String> bq;

	public Producer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}

	@Override
	public void run()
	{
		String[] strArr = new String[]
		{ "Java", "Struts", "Spring" };
		for (int i = 0; i < 99999999; i++)
		{
			System.out.println(getName() + "生产者准备生产集合元素!");
			try
			{
				TimeUnit.SECONDS.sleep(200);
				bq.put(strArr[i % 3]);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(getName() + "生产完成:" + bq);
		}
	}
}

class Consumer extends Thread
{
	private BlockingQueue<String> bq;

	public Consumer()
	{
		this.bq = bq;
	}

	@Override
	public void run()
	{
		while (true)
		{
			System.out.println(getName() + "消费者准备消费集合元素! ");
			try
			{
				TimeUnit.SECONDS.sleep(200);
				// 尝试取出元素,如果队列已空,则线程被阻塞
				bq.take();
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				System.out.println(getName() + "消费完成:" + bq);
				e.printStackTrace();
			}
		}
	}
}
