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
public class Exercise_jiangyi_mutilThread_2
{
	public static void main(String[] args)
	{
		parkCar pc = new parkCar();
		Thread t1 = new Thread(new Parking_lot(pc), "线程1");
		Thread t2 = new Thread(new Parking_lot(pc), "线程2");
		Thread t3 = new Thread(new Parking_lot(pc), "线程3");
		Thread t4 = new Thread(new Parking_lot(pc), "线程4");
		Thread t5 = new Thread(new Parking_lot(pc), "线程5");
		Thread t6 = new Thread(new Parking_lot(pc), "线程6");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class Parking_lot implements Runnable
{
	private parkCar parkcar;

	/**
	 * @param parkcar
	 */
	public Parking_lot(parkCar parkcar)
	{
		this.parkcar = parkcar;
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
		while (true)
		{
			parkcar.parkCarMethod();
			parkcar.driverCarMethod();
		}
	}

}

class parkCar
{
	private boolean[] park = new boolean[3];
	private Lock carLock = new ReentrantLock();
	private Condition parkOrDriverCar = carLock.newCondition();

	public void parkCarMethod()
	{
		try
		{
			carLock.lock();
			int i = 0;
			for (; i < 3; i++)
			{
				if (!park[i])
				{ // 有车即为true,无车为false
					park[i] = true;
					System.out.println(" 停车成功,停车的车位为: " + i);
					parkOrDriverCar.signalAll();
					break;
				}
			}

			if (i == 3)
			{
				System.out.println("等待停车!");
				parkOrDriverCar.await();
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			carLock.unlock();
		}
	}

	public void driverCarMethod()
	{
		try
		{
			carLock.lock();
			int i = 0;
			for (; i < 3; i++)
			{
				if (park[i])
				{ // 有车即为true,无车为false
					park[i] = false;
					System.out.println("路面畅通，请随时开车!");
					parkOrDriverCar.signalAll();
					break;
				}
			}
			if (i == 3)
			{
				System.out.println("车库无车,不能开车!");
				parkOrDriverCar.await();

			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			carLock.unlock();
		}
	}
}