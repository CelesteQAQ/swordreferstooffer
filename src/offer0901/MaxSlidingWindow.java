package offer0901;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: celeste
 * @create: 2020-09-01 00:56
 * @description:
 * 题目：剑指 Offer 59 - I. 滑动窗口的最大值
 * 描述：给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 **/
public class MaxSlidingWindow {
    /**
     * 暴力解法，从第一个开始比较后面k个数字，找到最大值
     * 循环下去
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        int len = nums.length;
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++){
            res[i] = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++){
                res[i] = Math.max(res[i], nums[j]);
            }
        }
        return res;
    }

    /**
     * 单调栈方法
     * 建立一个双端队列，只保留最大的值的下标（最大到当前位置的最大下标）
     * 当前目标值一定会入队列，因为确保后面的位置可以到达k个
     * 队列第一个是当前k个中最大的下标，队列最后一个是比当前位置大的最后一个
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k){
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 队列中第一个位置超出k范围，去掉
            if (!deque.isEmpty() && (i - deque.peek() >= k)){
                deque.pollFirst();
            }
            // 当前位置的值比队列最后位置的值要大，去掉，确保队列中的位置都是比当前位置的值大的位置
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            // 每个元素都必须加入一次
            deque.offer(i);
            //i的位置超过k就可以向结果里面添加
            if (i >= k - 1){
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
        return res;
    }
}
