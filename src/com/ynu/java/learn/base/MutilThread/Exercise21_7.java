/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.concurrent.TimeUnit;

/**
 * @author root
 *
 */
public class Exercise21_7 {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread d = new Thread(new Daemon_1());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon()= " + d.isDaemon() + ",");
		TimeUnit.SECONDS.sleep(1);
	}

}

class Daemon_1 implements Runnable {
	private Thread[] t = new Thread[10];

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn_1());
			t[i].start();
			long rand = (long) (Math.random() * 1000);
			try {
				TimeUnit.SECONDS.sleep(rand);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("DaemonSawn " + i + "started .");
		}
		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "].isDaemon() =" + t[i].isDaemon() + ", ");
		}
		while (true)
			Thread.yield();
	}

}

class DaemonSpawn_1 implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(1000);
				Thread.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
