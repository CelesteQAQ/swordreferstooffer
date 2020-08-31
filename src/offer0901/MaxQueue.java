package offer0901;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-09-01 01:53
 * @description:
 * 题目：剑指 Offer 59 - II. 队列的最大值
 * 描述：请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 **/
public class MaxQueue {
    /**
     * 其实就是前面一题的最大滑动窗口的最大值的单调队列问题
     * 使用双端队列保存比当前位置大的值的位置，随着队列的弹出更新
     */
    Deque<Integer> deque;//放置比当前位置的值要大的位置，不更新如何更新queue的位置
    List<Integer> queue;
    int i = 0;
    int k = 0;
    public MaxQueue() {
        deque = new ArrayDeque<Integer>();
        queue = new LinkedList<>();

    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        //注意查找的位置变成来双端队列顶部减去已经去掉的个数，因为双端队列没有更新位置，所以需要额外的值来更新
        return queue.get(deque.peek() - k);

    }

    public void push_back(int value) {
        queue.add(value);
        //添加时需要将队列中比当前位置的值小的位置弹出
        while (!deque.isEmpty() && value > queue.get(deque.peekLast() - k)){
            deque.pollLast();
        }
        //注意添加的是添加这个数的位置，就是删除不删除都不会改变双端队列的值
        deque.offer(i++);

    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        //如果需要弹出的值是双端队列的最前面的位置，那么就将队列的最前面的位置弹出
        if (!deque.isEmpty() && deque.peek() == k){
            deque.pollFirst();
        }
        k++;
        //删除队列中的第一个值
        int res = queue.get(0);
        queue.remove(0);
        return res;

    }
}
