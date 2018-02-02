/*
 * Copyright (c) 2018, YouCash and/or its affiliates. All rights reserved.
 * YouCash PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ynu.java.learn.base.MutilThread;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * @author root
 *
 */
public class PredicateTest2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Collection<String> books = new HashSet<>();
		books.add("Java编程思想");
		books.add("Java疯狂讲义");
		books.add("代码整洁之道_程序员的职业素养");
		books.add("java并发编程的艺术");
		books.add("TensorFlow 实战深度学习框架");
		books.add("人际关系与沟通");
		books.add("Effective java");
		books.add("代码整洁之道");
		books.add("TensorFlow实战");

		// 统计书名包含"Java"子串的图书数量
		System.out.println(calAll(books, ele -> ((String) ele).contains("Java")));
		// 统计书名包含"疯狂"子串的图书数量
		System.out.println(calAll(books, ele -> ((String) ele).contains("疯狂")));
		// 统计书名字符长度大于10的图书数量
		System.out.println(calAll(books, ele -> ((String) ele).length() > 10));
	}

	/**
	 * @param books
	 * @param object
	 * @return
	 */
	private static int calAll(Collection<String> books, Predicate p)
	{
		// TODO Auto-generated method stub
		int total = 0;
		for (Object obj : books)
		{
			if (p.test(obj))
			{
				total++;
			}
		}
		return total;
	}

}
