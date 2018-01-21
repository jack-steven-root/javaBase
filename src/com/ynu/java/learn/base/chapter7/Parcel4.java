/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcel4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcel4 p = new Parcel4();
		Destination d = p.dest("Tanzania");
	}

	public Destination dest(String s) {
		class PDestination implements Destination {
			private String label;

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

			private PDestination(String whereTo) {
				label = whereTo;
			}

		}
		return new PDestination(s);
	}

}
