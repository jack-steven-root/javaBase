/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
interface Selector {
	boolean end();

	Object current();

	void next();
}

public class Sequence {
	private Object[] o;
	private int next = 0;

	public Sequence(int size) {
		o = new Object[size];
	}

	public void add(Object x) {
		if (next < o.length) {
			o[next] = x;
			next++;
		}
	}

	private class SSelector implements Selector {
		int i = 0;

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Selector#end()
		 */
		@Override
		public boolean end() {
			// TODO Auto-generated method stub
			return i == o.length;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Selector#current()
		 */
		@Override
		public Object current() {
			// TODO Auto-generated method stub
			return o[i];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Selector#next()
		 */
		@Override
		public void next() {
			// TODO Auto-generated method stub
			if (i < o.length) {
				i++;
			}
		}

	}

	public Selector getSelector() {
		return new SSelector();
	}

	public static void main(String[] args) {
		Sequence s = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			s.add(Integer.toString(i));
		}
		Selector s1 = s.getSelector();
		while (!s1.end()) {
			System.out.println((String) s1.current());
			s1.next();
		}
	}
}
