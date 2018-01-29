/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author root
 *
 */
public class Exercise_java_jiangyi
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Print p = new Print();
		Thread printnumber = new Thread(new printList_1(p));
		Thread printchar = new Thread(new printList_2(p));

		Thread printnumber_1 = new Thread(new printList_1(p));
		Thread printchar_1 = new Thread(new printList_2(p));

		printnumber.start();
		printchar.start();

		printnumber_1.start();
		printchar_1.start();
	}

}

class printList_1 implements Runnable
{
	private Print p;

	/**
	 * @param p
	 */
	public printList_1(Print p)
	{
		this.p = p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++)
		{
			p.printNumber();
		}
	}
}

class printList_2 implements Runnable
{
	Print p;

	/**
	 * @param p
	 */
	public printList_2(Print p)
	{
		this.p = p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 26; i++)
		{
			p.printChar();
		}
	}

}

class Print
{
	private int i = 1;
	private char j = 'A';
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void printNumber()
	{
		try
		{
			lock.lock();
			System.out.print(i + "" + (i + 1));
			i += 2;
			condition.signalAll();

			if (i < 52)
			{
				condition.await();
			}

		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}

	public void printChar()
	{
		try
		{
			lock.lock();
			System.out.print(j);
			j++;
			condition.signalAll();
			if (j <= 'Z')
			{
				condition.await();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
	}
}