package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 22:30
 * @description:
 * 题目：剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 描述：在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。
 * 请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 **/
public class SingleNumber {
    /**
     * 最多只出现3次，只有一个出现1次
     * seen_Once是保留只出现一次的数字
     * seen_Twice是保留值出现2次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums){
        int seen_Once = 0, seen_Twice = 0;
        for (int num : nums){
            //这个是出现2次里面没有的，但是一次出现
            //x&(~x) = 0
            //x ^ 0 = x;
            //x^x = 0;
            //第一次出现，～0&（0^x) = x;~x&(0^x)=0
            //第二次出现：~0&(x^x)=0;~0&(0^x)=x
            //第三次出现：～x&(0^x)=0;~0&(x^x)=0;
            seen_Once = ~seen_Twice & (seen_Once ^ num);//2次不是x，1次是0就是第一次出现
            seen_Twice = ~seen_Once & (seen_Twice ^ num);//
        }
        return seen_Once;
    }

    /**
     * 方法2看不懂
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < 64; i++){
            int sum = 0;
            for (int j = 0; j < nums.length; j++){
                sum += (nums[j] >> i) & 1;
            }
            result = result | ((sum % 3) << i);
        }
        return result;
    }
}
