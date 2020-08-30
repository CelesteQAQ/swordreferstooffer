package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 16:08
 * @description:
 * 题目：剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 描述：统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 **/
public class Search {
    /**
     * 暴力解法直接遍历一遍如何相等就加一
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target){
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target) count++;
        }
        return count;
    }

    /**
     * 二分查找的方法
     * 使用来2次二分查找，时间是2*O（NlogN）
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target){
        int left = searchLeft(nums,0, nums.length - 1, target);
        int right = searchRight(nums, 0, nums.length - 1, target);
        //没有找到就返回0
        if (left == Integer.MAX_VALUE) return 0;
        return right - left + 1;
    }

    /**
     * 找到右边出现的边界
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int searchRight(int[] nums, int start, int end, int target) {
        int right = Integer.MIN_VALUE;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return Math.max(mid, searchRight(nums, mid + 1, end, target));
            }else if (nums[mid] < target){
                return searchRight(nums, mid + 1, end, target);
            }else if (nums[mid] > target){
                return searchRight(nums, start, mid - 1, target);
            }
        }
        return right;
    }

    /**
     * 找到左边边界
     * 如果中间值等于目标值，如何做？
     * 记下当前位置，然后遍历左边区域，如果左边不存在就是现在的最左边
     * 如果中间值小于目标值，如何做？
     * 如果中间值大于目标值，如何做？
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int searchLeft(int[] nums, int start, int end, int target) {
        int left = Integer.MAX_VALUE;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return Math.min(searchLeft(nums, start, mid - 1, target), mid);
            }else if (nums[mid] < target){
                return searchLeft(nums, mid + 1, end, target);
            }else if (nums[mid] > target){
                return searchLeft(nums, start, mid - 1, target);
            }

        }
        return left;
    }

}
