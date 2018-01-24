/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Controller {
	private EventSet es = new EventSet();

	public void addEvent(Event c) {
		es.add(c);
	}

	public void run() {
		Event e;
		while ((e = es.getNext()) != null) {
			if (e.ready()) {
				e.action();
				System.out.println(e.description());
				es.removeCurrent();
			}
		}
	}
}

class EventSet {
	private Event[] events = new Event[100];
	private int index = 0;
	private int next = 0;

	public void add(Event e) {
		if (index >= events.length)
			return;
		events[index++] = e;
	}

	public Event getNext() {
		boolean looped = false;
		int start = next;
		do {
			next = (next + 1) % events.length;
			// see if it has looped to the beginning
			if (start == next)
				looped = true;
			// if it loops past start,the list is empty
			if ((next == (start + 1) % events.length) && looped)
				return null;
		} while (events[next] == null);
		return events[next];
	}

	public void removeCurrent() {
		events[next] = null;
	}
}
