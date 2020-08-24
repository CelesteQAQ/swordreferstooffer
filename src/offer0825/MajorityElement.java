package offer0825;

import java.util.Arrays;

/**
 * @author: celeste
 * @create: 2020-08-24 23:23
 * @description:
 * 题目：剑指 Offer 39. 数组中出现次数超过一半的数字
 * 描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 **/
public class MajorityElement {
    /**
     * 摩尔投票法。因为肯定有超多半数的众数，所以是每遇到一个杀一个，
     * 肯定有一个最后活下来的是超过半数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums){
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (count == 0){
                candidate = nums[i];
                count++;
            }else {
                if (candidate == nums[i]){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return candidate;
    }

    /**
     * 排序之后的中间值就是众数
     * @param nums
     * @return
     */
    public int majorityElement_1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


}
