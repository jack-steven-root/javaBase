/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcel9 {
	public Destination dest(final String dest, final float price) {
		return new Destination() {
			private int cost;
			// Instance initialization for each object;
			{
				cost = Math.round(price);
				if (cost > 100) {
					System.out.println("Over budget!");
				}
			}
			private String label = dest;

			@Override
			public String readLabel() {
				return label;
			}
		};

	}

	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.dest("Tanzania", 110111.234f);
	}
}
