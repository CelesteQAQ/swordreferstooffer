package offer0812;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: celeste
 * @create: 2020-08-12 21:04
 * @description:
 * 题目：剑指 Offer 03. 数组中重复的数字
 * 描述：找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 **/
public class FindRepeatNumber {
    /**
     * Java里面的set就是如果无法添加就是已经存在，当返回false时就可以return 这个数字
     * 肯定是有重复的
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 另一种方法可以在无额外空间复杂度下完成查找重复数字
     * 因为注意数字的范围是在0～n-1之间，所以可以将数字移动到数字的下标位置
     * 这样遇到就交换，遇到重复的发现原来下标已经有相同数字了
     * 2, 3, 1, 0, 2, 5, 3
     * 1, 3, 2, 0, 2, 5, 3
     * 3, 1, 2, 0, 2, 5, 3
     * 0, 1, 2, 3, 2, 5, 3
     * 0, 1, 2, 3, *
     */

    public int findRepeatNumber_1(int[] nums) {
        if (nums == null || nums.length <= 0){
            return -1;
        }
//        for (int i = 0; i < nums.length; i++){
//            if (nums[i] < 0 || nums[i] > nums.length - 1) {
//                return -1;
//            }
//        }
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;//注意这里要使用【temp】，要不然会陷入死循环
            }
        }
        return -1;
    }
}
