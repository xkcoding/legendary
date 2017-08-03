package com.xkcoding.legendary.queue;

import java.util.concurrent.TimeUnit;

public class MyQueueTest {
	public static void main(String[] args) {
		final MyQueue queue = new MyQueue(5);

		queue.put("a");
		queue.put("b");
		queue.put("c");
		queue.put("d");
		queue.put("e");

		System.out.println(String.format("当前队列的长度: {}", queue.getSize()));
		Thread t1 = new Thread(() -> {
			queue.put("f");
			queue.put("g");
			queue.put("h");
		}, "t1");


		Thread t2 = new Thread(() -> {
			queue.get();
			queue.get();
		});

		t1.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
