package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 20:54
 * @description:
 * 题目：剑指 Offer 56 - I. 数组中数字出现的次数
 * 描述：一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 **/
public class SingleNumbers {
    public int[] singleNumbers(int[] nums){
        int[] result = new int[2];
        int sum = 0;
        //求异或就是2个只出现一次的两个数的异或
        for (int num : nums){
            sum ^= num;
        }
        //异或结果的第一个1也是其中一个数字提供的
        //取出低位第一个不为0的1，-sum = ～sum+1
        int lowerBit = sum & (-sum);
        for (int num : nums){
            //那一位为0的为一组
            if ((num&lowerBit) == 0){
                result[0] ^= num;
                //那一位不为0的为一组
            }else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
