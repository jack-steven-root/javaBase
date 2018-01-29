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
public class CollectionEach
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 创建一个集合
		Collection books = new HashSet();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		books.add("疯狂Android讲义");

		// 调用forEach()方法遍历集合
		// books.forEach(obj -> System.out.println("迭代集合元素:" + obj));
		books.forEach(obj -> System.out.println("迭代集合元素:" + obj));

	}

}
