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
public class ThreadVariations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class InnerThread1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner extends Thread {
		Inner(String name) {
			super(name);
			start();
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.print(this);
					if (--countDown == 0)
						return;
					sleep(10);
				}
			} catch (InterruptedException e) {
				System.out.print("interrupted");
			}
		}

		@Override
		public String toString() {
			return getName() + ": " + countDown;
		}
	}

	public InnerThread1(String name) {
		inner = new Inner(name);
	}
}

// Using an anonymous inner class
class InnerThread2 {
	private int countDown = 5;
	private Thread t;

	public InnerThread2(String name) {
		t = new Thread(name) {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.print(this);
						if (--countDown == 0)
							return;
						sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.print("sleep() interrupted ");
				}
			}

			@Override
			public String toString() {
				return getName() + ": " + countDown;
			}
		};
		t.start();
	}
}

// Using a named Runnable implementation
class InnerRunnable1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner implements Runnable {
		Thread t;

		Inner(String name) {
			t = new Thread(this, name);
			t.start();
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.print(this);
					if (--countDown == 0)
						return;
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Override
		public String toString() {
			return t.getName() + ": " + countDown;
		}
	}

	public InnerRunnable1(String name) {
		inner = new Inner(name);
	}
}

// Using an anonymous Runable implementation:
class InnerRunnable2 {
	private int countDown = 5;
	private Thread t;

	public InnerRunnable2(String name) {
		t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.print(this);
						if (--countDown == 0)
							return;
						TimeUnit.MILLISECONDS.sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.print("sleep() interrupted");
					e.printStackTrace();
				}
			}

			@Override
			public String toString() {
				return Thread.currentThread().getName() + ": " + countDown;
			}

		}, name);
		t.start();
	}
}

// A separate method to run some code as a task
class ThreadMethod {
	private int countDown = 5;
	private Thread t;
	private String name;

	public ThreadMethod(String name) {
		this.name = name;
	}

	public void runTask() {
		if (t == null) {
			t = new Thread(name) {
				@Override
				public void run() {
					try {
						while (true) {
							System.out.print(this);
							if (--countDown == 0)
								return;
							sleep(10);
						}
					} catch (InterruptedException e) {
						System.out.print("sleep() interrupted ");
					}
				}

				@Override
				public String toString() {
					return getName() + ": " + countDown;
				}
			};
			t.start();
		}
	}

}
