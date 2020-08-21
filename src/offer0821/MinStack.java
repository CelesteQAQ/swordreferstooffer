package offer0821;

import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-08-21 10:38
 * @description:
 * 题目：剑指 Offer 30. 包含min函数的栈
 * 描述：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 **/
public class MinStack {
    Stack<Integer> statck = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        statck.push(x);
        if (minStack.isEmpty()){
            minStack.push(x);
        }else {
            minStack.push(Math.min(x, minStack.peek()));
        }

    }

    public void pop() {
        statck.pop();
        minStack.pop();

    }

    public int top() {

        return statck.peek();

    }

    public int min() {
        return minStack.peek();

    }
}
