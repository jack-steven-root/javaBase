/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author root
 *
 */
public class IteratorEach
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Collection<String> books = new HashSet<>();
		books.add("Java编程思想");
		books.add("Java多线程编程的艺术");
		books.add("编码简介之道");
		books.add("疯狂Java讲义");

		Iterator it = books.iterator();
		// 使用Lamdba表达式(目标类型是Comsumer)来遍历集合元素
		it.forEachRemaining(obj -> System.out.println("迭代集合元素:" + obj));
	}

}
