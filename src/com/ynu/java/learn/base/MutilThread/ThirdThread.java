/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author root
 *
 */
public class ThirdThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 创建Callable对象
		ThirdThread rt = new ThirdThread();
		FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				int i = 0;
				for (; i < 100; i++) {
					System.out.println(Thread.currentThread().getName() + "的循环变量i的值:" + i);
				}
				return i;
			}
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量i的值:" + i);
			if (i == 20) {
				// 实质还是以Callable对象来创建并启动线程的
				new Thread(task, "有返回值的线程").start();
			}
		}
		try {
			// 获取线程返回值
			System.out.println("子线程的返回值:" + task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
