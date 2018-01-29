/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

/**
 * @author root
 *
 */
public class BasicThread {
	public static void main(String[] args) {
		Thread[] threadArray = { new Thread(new LiftOff()), new Thread(new LiftOff()), new Thread(new LiftOff()) };
		for (Thread oneThread : threadArray) {
			oneThread.start();
		}
		System.out.println("Waiting for LiftOff");
	}
}
