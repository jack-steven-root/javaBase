/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author root
 *
 */
public class ThreadPoolTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ExecutorService pool = Executors.newFixedThreadPool(7);
		Runnable target = new Runnable()
		{

			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for (int i = 0; i < 100; i++)
				{
					System.out.println(Thread.currentThread().getName() + "的i值为:" + i);
				}
			}

		};
		pool.submit(target);
		pool.execute(target);

		// 关闭线城池
		pool.shutdown();
	}

}
