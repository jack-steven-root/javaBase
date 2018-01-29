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
public class IteratorTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Collection<String> books = new HashSet<>();
		books.add("明朝那些事");
		books.add("三国演义!");
		books.add("水浒传!");
		books.add("Java编程思想");

		Iterator<String> it = books.iterator();
		while (it.hasNext())
		{
			// it.next()方法返回的数据类型是Object类型,因此需要强制类型转换
			String book = it.next();
			System.out.println(book);
			if (book.equals("三国演义!"))
			{
				it.remove();
			}
			// 对book变量赋值,不会改变集合元素本身
			book = "测试字符串";
		}
		System.out.println(books);
	}

}
