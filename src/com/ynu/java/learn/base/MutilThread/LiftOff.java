/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int tackCount = 0;
	private final int id = tackCount++;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + ").";
	}

	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
	}
}
