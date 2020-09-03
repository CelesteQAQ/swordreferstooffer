package offer0904;

import java.util.Arrays;

/**
 * @author: celeste
 * @create: 2020-09-04 02:11
 * @description:
 * 题目：剑指 Offer 61. 扑克牌中的顺子
 * 描述：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 **/
public class IsStraight {
    /**
     * 直接暴力排序之后遍历一遍，如果是0就计数0加一，如果不等于前一个数字+1就减去一个0，
     * 直到没有0了但是依旧是没有是pre+1就返回false
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums){
        int pre = 0;
        int zeroCount = 0;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < 5; i++){
            //计数0的个数
            if (nums[i] == 0) {
                zeroCount++;
            }
            else {
                //前面是0就从这里开始
                if (pre == 0) pre = nums[i];
                //是前面的数字加一就继续遍历
                else if (nums[i] == pre + 1) pre = nums[i];
                //不是前面数字加一情况
                else if (nums[i] != pre + 1){
                    //0的个数不是0
                    while (zeroCount > 0 && nums[i] != pre + 1){
                        //0的个数减一，更新前一个数字的值
                        zeroCount--;
                        pre++;
                    }
                    //如果0的个数已经是0并且依旧不是前面数字+1
                    if (nums[i] != pre + 1) return false;
                    //是就更新前一个数字
                    else pre++;
                }
            }
        }
        return true;
    }
}
