/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author root
 *
 */
public class BlockingQueueTest
{
	public static void main(String[] args)
	{
		// 定义一个长度为2的阻塞队列
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);
		try
		{
			bq.put("java");
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
