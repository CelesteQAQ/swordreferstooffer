package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 23:45
 * @description:
 * 题目：剑指 Offer 57. 和为s的两个数字
 * 描述：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 **/
public class TwoSum {
    /**
     * 左右指针问题
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left < right){
            if (nums[right] + nums[left] == target) return new int[]{nums[left], nums[right]};
            else if (nums[right] + nums[left] < target) left++;
            else if (nums[right] + nums[left] > target) right--;
        }
        return new int[]{};
    }
}
