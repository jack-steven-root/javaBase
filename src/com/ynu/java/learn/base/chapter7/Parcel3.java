/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcel3 {
	private class PContents extends Contents {
		private int i = 11;

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Contents#value()
		 */
		@Override
		public int value() {
			// TODO Auto-generated method stub
			return i;
		}

	}

	protected class PDestination implements Destination {
		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Destination#readLabel()
		 */
		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return label;
		}

	}

	public Destination dest(String s) {
		return new PDestination(s);
	}

	public Contents cont() {
		return new PContents();
	}

}

abstract class Contents {
	abstract public int value();
}

interface Destination {
	String readLabel();
}

class Test {
	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Contents c = p.cont();
		Destination d = p.dest("Tanzania");
		// 因为PDestination没有公共的构造函数,所以上述的引用是错误的
		// Parcel3.PDestination d1 = p.new PDestination("test123");
		// 因为PContents是访问权限是私有的，因此及下列的引用也是错误的
		// Parcel3.PContents c=p.new PContents();
	}
}