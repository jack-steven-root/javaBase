/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Parcel5 {
	private void internalTracking(boolean b) {
		if (b) {
			class TrackingSlip {
				private String id;

				TrackingSlip(String s) {
					id = s;
				}

				String getSlip() {
					return id;
				}
			}
			TrackingSlip ts = new TrackingSlip("slip");
			String s = ts.getSlip();
		}
		// Can't use it here! Out of scope:
		// ! TrackingSlip ts=new TrackingSlip("x");

	}

	public void track() {
		internalTracking(true);
	}

	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		p.track();
	}
}
