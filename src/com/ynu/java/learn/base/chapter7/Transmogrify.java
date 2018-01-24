/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class Transmogrify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stage s = new Stage();
		s.go();
		s.change();
		s.go();
	}

}

interface Actor {
	void act();
}

class HappyActor implements Actor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Actor#act()
	 */
	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("HappyActor");
	}

}

class SadActor implements Actor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Actor#act()
	 */
	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("SadActor");
	}

}

class Stage {
	Actor a = new HappyActor();

	void change() {
		a = new SadActor();
	}

	void go() {
		a.act();
	}
}