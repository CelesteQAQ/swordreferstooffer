package offer0825;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-08-25 01:17
 * @description:
 * 题目：剑指 Offer 41. 数据流中的中位数
 * 描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 **/
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<>((n1, n2) -> n2 - n1);
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (left.size() + 1 < right.size()){
            left.add(right.poll());
        }

    }

    public double findMedian() {
        if (left.size() == right.size() - 1){
            return right.peek();
        }
        return (double)(left.peek() + right.peek()) / 2;

    }
}
