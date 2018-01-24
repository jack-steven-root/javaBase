/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public abstract class Event {
	private long evtTime;

	public Event(long eventTime) {
		evtTime = eventTime;
	}

	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}

	abstract public void action();

	abstract public String description();
}
