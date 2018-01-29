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
public class ForeachTest
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

		for (Object obj : books)
		{
			String book = (String) obj;
			System.out.println(book);
			if (book.equals("疯狂Java讲义"))
			{
				// 下面代码会引发ConcurrentModificationException异常
				books.remove(book);
			}
		}
		System.out.println(books);
	}

}
