/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcel10 {
	private static class PContents extends Contents {
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

	protected static class PDestination implements Destination {

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Destination#readLabel()
		 */
		private String label;

		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return label;
		}

		private PDestination(String whereTo) {
			label = whereTo;
		}

	}

	public static Destination dest(String s) {
		return new PDestination(s);
	}

	public static Contents cont() {
		return new PContents();
	}

	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Parcel10.PDestination pp = new Parcel10.PDestination("test");
		Contents c = cont();
		Destination d = dest("Tanzania");
	}
}

interface Destiantion {
	String readLabel();
}
