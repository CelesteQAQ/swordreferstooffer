package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 01:45
 * @description:
 * 题目：剑指 Offer 51. 数组中的逆序对
 * 描述：在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 **/
public class ReversePairs {
    /**
     * 最笨的方法就是暴力解法，从第一个开始穷举所有可能
     * 但是会超过时间
     * @param nums
     * @return
     */
    public int reversePairs1(int[] nums){
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (nums[i] > nums[j]) ans++;
            }
        }
        return ans;
    }

    /**
     * 按照归并排序的顺序来处理，因为在合并的过程中会有前后2个数组的比较
     * @param nums
     * @return
     */
    public int reversePairs2(int[] nums){
        int len = nums.length;
        if (len < 2){
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++){
            copy[i] = nums[i];
        }
        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * divide的过程
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        //前后两个数组没有大小差距，就是前面所有数字都比后面的小，不需要合并
        if (nums[mid] <= nums[mid + 1]) return leftPairs + rightPairs;
        //需要合并
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * 合并并且比较计数的过程
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++){
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++){
            //前面数组复制结束
            if (i == mid + 1) nums[k] = temp[j++];
            //后面数组复制结束
            else if (j == right + 1) nums[k] = temp[i++];
            //前面的数字比后面的数字要小，不需要移动
            else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
                //后面数字比前面的小，那么前面数组的数字到后面数组的数字的逆序对就是这两个数字之间的距离
            }else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
