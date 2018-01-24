/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.chapter7;

/**
 * @author root
 *
 */
public class GreenhouseControls extends Controller {
	private boolean light = false;
	private boolean water = false;
	private String thermostat = "Day";

	private class LightOn extends Event {

		/**
		 * @param eventTime
		 */
		public LightOn(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#action()
		 */
		@Override
		public void action() {
			// TODO Auto-generated method stub
			// Put hardware control code here to physically turn on the light
			light = true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#description()
		 */
		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Light  is on";
		}

	}

	private class LightOff extends Event {

		/**
		 * @param eventTime
		 */
		public LightOff(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// put hardware control code here to
			// physically turn off the light
			light = false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#description()
		 */
		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Light is off";
		}
	}

	private class WaterOn extends Event {

		/**
		 * @param eventTime
		 */
		public WaterOn(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#action()
		 */
		@Override
		public void action() {
			// TODO Auto-generated method stub
			water = true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#description()
		 */
		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Greenhouse water is on";
		}
	}

	private class WaterOff extends Event {

		/**
		 * @param eventTime
		 */
		public WaterOff(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#action()
		 */
		@Override
		public void action() {
			// TODO Auto-generated method stub
			water = false;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#description()
		 */
		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Greenhouse water is off";
		}

	}

	private class ThermostatNight extends Event {

		/**
		 * @param eventTime
		 */
		public ThermostatNight(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			thermostat = "Hight";
		}

		@Override
		public String description() {
			return "Thermostat on night setting";
		}
	}

	private class ThermostatDay extends Event {

		/**
		 * @param eventTime
		 */
		public ThermostatDay(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// put hardware control code here
			thermostat = "Day";
		}

		@Override
		public String description() {
			return "Thermostat on day setting";
		}
	}

	// An example of an action() that inserts a new one of itself into the event
	// list;
	private int rings;

	private class Bell extends Event {

		/**
		 * @param eventTime
		 */
		public Bell(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// Ring bell every 2 seconds,rings times
			System.out.println("Bing!");
			if (--rings > 0)
				addEvent(new Bell(System.currentTimeMillis() + 2000));
		}

		@Override
		public String description() {
			return "Ring bell";
		}
	}

	private class Restart extends Event {

		/**
		 * @param eventTime
		 */
		public Restart(long eventTime) {
			super(eventTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			long tm = System.currentTimeMillis();
			// Instead of hard-wiring,you could parse
			// configuration information from a text file here
			rings = 5;
			addEvent(new ThermostatNight(tm));
			addEvent(new LightOn(tm + 1000));
			addEvent(new LightOff(tm + 2000));
			addEvent(new WaterOn(tm + 3000));
			addEvent(new WaterOff(tm + 8000));
			addEvent(new Bell(tm + 9000));
			addEvent(new ThermostatDay(tm + 10000));

			// can even add a restart object!
			addEvent(new Restart(tm + 20000));

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ynu.java.learn.base.chapter7.Event#description()
		 */
		@Override
		public String description() {
			// TODO Auto-generated method stub
			return "Restarting System";
		}
	}

	public static void main(String[] args) {
		GreenhouseControls gc = new GreenhouseControls();
		long tm = System.currentTimeMillis();
		gc.addEvent(gc.new Restart(tm));
		gc.run();
	}
}
