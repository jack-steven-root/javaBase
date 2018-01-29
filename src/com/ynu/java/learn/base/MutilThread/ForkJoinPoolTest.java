/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * @author root
 *
 */
public class ForkJoinPoolTest
{

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		ForkJoinPool pool = new ForkJoinPool();
		// 提交可分解的PrintTask任务
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS);
		// 关闭线城池
		pool.shutdown();
	}

}

// 继承RecursiveAction来实现"可分解"的任务
class PrintTask extends RecursiveAction
{
	// 每个"小任务"最多只打印50个数
	private static final int THRESHOLD = 50;
	private int start;
	private int end;
	// 打印从start到end的任务

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.concurrent.RecursiveAction#compute()
	 */
	@Override
	protected void compute()
	{
		// TODO Auto-generated method stub
		// 当end与start之间的差小于THRESHOLD时,开始打印
		if (end - start < THRESHOLD)
		{
			for (int i = start; i < end; i++)
			{
				System.out.println(Thread.currentThread().getName() + "的i的值:" + i);
			}
		}
		else
		{
			// 当end与start之间的差大于THERSHOLD,即要打印的数超过50个时
			// 将大任务分解成两个"小任务"
			int middle = (start + end) / 2;
			PrintTask left = new PrintTask(start, middle);
			PrintTask right = new PrintTask(middle, end);
			// 并行执行两个"小任务"
			left.fork();
			right.fork();
		}
	}

	/**
	 * @param start
	 * @param end
	 */
	public PrintTask(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

}
