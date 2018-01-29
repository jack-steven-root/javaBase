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
public class Daemons {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon()= " + d.isDaemon() + ",");
		TimeUnit.SECONDS.sleep(1);
	}

}

class Daemon implements Runnable {
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
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSawn " + i + "started .");
		}
		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "].isDaemon() =" + t[i].isDaemon() + ", ");
		}
		while (true)
			Thread.yield();
	}

}

class DaemonSpawn implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Thread.yield();
		}
	}

}
