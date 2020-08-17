package offer0818;

import java.awt.event.MouseAdapter;

/**
 * @author: celeste
 * @create: 2020-08-18 01:51
 * @description:
 * 题目：剑指 Offer 17. 打印从1到最大的n位数
 * 描述：输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 跟书上的不一样
 **/
public class PrintNumbers {
    public int[] printNumber(int n){
        int len = (int)Math.pow(10, n) - 1;
        int[] result = new int[len];
        for (int i = 1; i <= len; i++){
            result[i - 1] = i;
        }
        return result;
    }

}
