package com.xkcoding.legendary.stack;

import com.xiaoleilu.hutool.util.StrUtil;

import java.util.concurrent.TimeUnit;

public class MyStackTest {
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(3);
		stack.push(1);
		stack.push(7);
		stack.push(5);
		stack.push(2);
		stack.push(1);
		stack.push(6);

		stack.show();

		System.out.println(StrUtil.format("栈中最小值为: {}", stack.getMin()));

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stack.pop();
		stack.pop();
		stack.show();
		System.out.println(StrUtil.format("栈中最小值为: {}", stack.getMin()));

	}
}
