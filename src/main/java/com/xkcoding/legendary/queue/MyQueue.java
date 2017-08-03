package com.xkcoding.legendary.queue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用 notify() 和 wait() 实现自定义阻塞队列
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.08.02 at 11:51:14
 */
public class MyQueue {

	// 1. 承载数据的容器
	private LinkedList<Object> queue = new LinkedList<Object>();

	// 2. 计数器，用于判定边界
	private AtomicInteger count = new AtomicInteger(0);
	private final int minSize = 0;

	// 3. 初始化一个对象，用于加锁
	private final Object lock = new Object();
	private final int maxSize;

	public MyQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	/**
	 * 添加一个元素到队列中，如果队列元素已满，则调用此方法的线程被阻塞，直到存在多余空间了，再进行添加
	 *
	 * @param obj 添加 obj 到队列尾部
	 */
	public void put(Object obj) {
		synchronized (lock) {
			// 1.没有多余空间，就阻塞线程
			while (count.get() == this.maxSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 2.添加元素
			queue.add(obj);
			// 3.计数器累加
			count.incrementAndGet();
			System.out.println(String.format("新加入的元素为：{}", obj));
			// 4.唤醒其他线程（若本来元素为空，有线程调用 get 方法，那么原本被阻塞的，需要在此时被唤醒）
			lock.notify();
		}
	}

	/**
	 * 获取一个元素，如果队列元素为空，则调用此方法的线程被阻塞，直到添加新元素了，再进行获取
	 *
	 * @return 返回队列的第一个元素
	 */
	public Object get() {
		Object ret = null;

		synchronized (lock) {
			// 1.没有元素，就阻塞线程
			while (count.get() == this.minSize) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 2.取第一个元素
			ret = queue.removeFirst();
			// 3.计数器递减
			count.decrementAndGet();
			System.out.println(String.format("移除的元素为：{}", ret));
			// 4.唤醒其他线程（若元素本来已满，有线程调用 put 方法，那么原本被阻塞的，需要在此时被唤醒）
			lock.notify();
		}

		return ret;
	}

	public int getSize() {
		return this.count.get();
	}

}