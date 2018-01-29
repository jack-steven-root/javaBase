/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class ExHandler
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5 / 0;
		System.err.println("程序正常结束!");
	}

}

class MyExHandler implements Thread.UncaughtExceptionHandler
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.
	 * Thread, java.lang.Throwable)
	 */
	// 实现uncaughtException()方法,该方法将处理的未处理异常
	@Override
	public void uncaughtException(Thread t, Throwable e)
	{
		// TODO Auto-generated method stub
		System.out.println(t + "线程出现了异常:" + e);
	}

	// 从上面程序的执行结果来看,虽然程序中的粗体字代码指定了异常处理器对未捕获的异常进行处理,而且该异常处理器
	// 也确实起作用了,但程序依然不会正常结束。这说明异常处理器与通过catch捕获异常是不同的--当使用catch捕获异常
	// 时，异常不会向上传播给上一级调用者;但使用异常处理器对异常进行处理之后,异常依然会传播给上一级调用者

}
