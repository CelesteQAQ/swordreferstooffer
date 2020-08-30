package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 17:33
 * @description:
 * 题目：剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 描述：一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，
 * 请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 **/
public class MissingNumber {
    /**
     * 也是二分查找法，对比i跟nums[i]，如果不对就是前面发生了变化
     * 只有1个数字保存为什么空间复杂度这么差？？
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1, state = nums.length;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid){
                left = mid + 1;
            }else if (nums[mid] > mid){
                state = Math.min(state, mid);
                right = mid - 1;
            }
        }
        return state;
    }
}
