package offer0820;

/**
 * @author: celeste
 * @create: 2020-08-20 14:36
 * @description:
 * 题目：剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 **/
public class Exchange {
    /**
     * 跟快排的交换有点类似，但是这个是奇偶交换，可以使用左右指针
     * @param nums
     * @return
     */
    public int[] exchange (int[] nums){
        if (nums == null || nums.length <= 1) return nums;
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        while (left < right){
            //左边找到第一个不是奇数的值
            while (left < len && nums[left] % 2 == 1) left++;
            //右边找到第一个不是偶数的值
            while (right >= 0 && nums[right] % 2 == 0) right--;
            //如果还在两边就交换
            if (left < right){
                int temp = nums[left];
                //注意需要将left和right加1，以便下次比较
                nums[left++] = nums[right];
                nums[right--] = temp;
            }
        }
        return nums;
    }
}
