/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
class DoBaseFinalization {
	public static boolean flag = false;
}

class Characteristic {
	String s;

	Characteristic(String c) {
		s = c;
		System.out.println("Creatiing " + s);
	}

	@Override
	protected void finalize() {
		System.out.println("finalizing Characteristic " + s);
	}
}

class LivingCreature {
	Characteristic p = new Characteristic("is alive");

	LivingCreature() {
		System.out.println("LivingCreature ()");
	}

	@Override
	protected void finalize() {
		System.out.println("LivingCreature finalize");
		if (DoBaseFinalization.flag) {
			try {
				super.finalize();
			} catch (Throwable t) {

			}
		}
	}
}

class Animal extends LivingCreature {
	Characteristic p = new Characteristic("has heart");

	Animal() {
		System.out.println("Animal() ");
	}

	@Override
	protected void finalize() {
		System.out.println("Animal finalize");
		if (DoBaseFinalization.flag) {
			try {
				super.finalize();
			} catch (Throwable t) {

			}
		}
	}
}

abstract class Amphibian extends Animal {
	Characteristic p = new Characteristic("can live in water");

	Amphibian() {
		System.out.println("Amphibian()");
		testString();
	}

	@Override
	protected void finalize() {
		System.out.println("Amphibian finalize");
		if (DoBaseFinalization.flag) {
			try {
				super.finalize();
			} catch (Throwable t) {
			}
		}
	}

	public abstract void testString();
}

public class Frog extends Amphibian {

	/**
	 * 
	 */
	Characteristic p = new Characteristic("can live in water ************");

	public Frog() {
		// TODO Auto-generated constructor stub
		System.out.println("Frog()");
	}

	@Override
	protected void finalize() {
		System.out.println("Frog finalize");
		if (DoBaseFinalization.flag) {
			try {
				super.finalize();
			} catch (Throwable t) {
			}
		}
	}

	public static void main(String[] args) {
		if (args.length != 0 && args[0].equals("finalize")) {
			DoBaseFinalization.flag = true;
		} else {
			System.out.println("not finalizing bases ");
		}
		new Frog();
		System.out.println("bye!");
		// Must do this to guarantee that all
		// finalizers will be called
		System.runFinalizersOnExit(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ynu.java.learn.base.chapter7.Amphibian#testString()
	 */
	@Override
	public void testString() {
		// TODO Auto-generated method stub
		System.out.println(p == null);
		// System.out.println(p.s);
	}

}
