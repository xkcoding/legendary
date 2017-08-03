package com.xkcoding.legendary.stack;

import java.util.Stack;

/**
 * 自定义栈，拥有栈的基本功能，并提供返回栈中最小值的操作
 *
 * @author Yangkai.Shen
 * @version 1.0
 * @date 2017.08.03 at 10:03:15
 */
public class MyStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public MyStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	/**
	 * 返回 stackData 中的栈顶元素
	 *
	 * @return 返回栈顶元素
	 */
	public Integer pop() {
		if (this.stackData.empty()) {
			throw new RuntimeException("栈中无元素！");
		}

		//返回 stackData 栈顶元素的同时，移除 stackMin 的栈顶元素
		this.stackMin.pop();

		return this.stackData.pop();
	}

	/**
	 * 将新数据压入栈中
	 *
	 * @param newNum 压入的新数据
	 */
	public void push(Integer newNum) {

		// 1.判断 stackData 中是否存在数据，不存在则同时压入 stackMin 中
		if (this.stackData.empty()) {
			stackMin.push(newNum);
		} else if (newNum < this.getMin()) {

			// 2.如果 stackData 不为空，则判断 newNum 与 stackMin 的栈顶元素的大小
			// 3.若 newNum 比 stackMin 的栈顶元素小，则 newNum 压入 stackData 的同时压入 stackMin
			stackMin.push(newNum);
		} else {

			// 4.若 newNum 比 stackMin 的栈顶元素大，则 newNum 压入 stackData 的同时，stackMin 重复压入 stackMin 的栈顶元素，即最小元素
			stackMin.push(this.getMin());
		}

		stackData.push(newNum);
	}

	/**
	 * 返回 stackMin 的栈顶元素
	 *
	 * @return 返回栈中最小值
	 */
	public Integer getMin() {
		if (stackMin.empty()) {
			throw new RuntimeException("栈中无元素！");
		}

		return this.stackMin.peek();
	}
}