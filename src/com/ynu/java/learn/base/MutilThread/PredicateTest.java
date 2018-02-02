/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author root
 *
 */
public class PredicateTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Collection<String> books = new HashSet<>();
		books.add(new String("轻量级Java EE企业应用实战"));
		books.add(new String("疯狂Java讲义"));
		books.add(new String("疯狂iOS讲义"));
		books.add(new String("疯狂Ajax讲义"));
		books.add(new String("疯狂Android讲义"));
		System.out.println(books);
		// 使用lambda表达式(目标类型是Predicate)过滤集合
		books.removeIf(ele -> ele.length() < 10);
		System.out.println(books);
	}

}
