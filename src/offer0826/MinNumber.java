package offer0826;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-26 11:37
 * @description:
 * 题目：剑指 Offer 45. 把数组排成最小的数
 * 描述：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 **/
public class MinNumber {
    /**
     * 需要最小，是不是可以从数字的第一位开始比较选择最小的，然后继续比较选择最小的
     * 那就把所有都换成字符串
     * 然后选择lambda增强的list的排序方法
     * @param nums
     * @return
     */
    public String minNumber(int[] nums){
        List<String> list = new LinkedList<>();
        for (int num : nums){
            list.add(String.valueOf(num));
        }
        //lambda函数与集合比较的结合
        list.sort((a, b) -> (a + b).compareTo(b + a));
        //注意join函数是可以将数组或者集合拼接起来
        return String.join("", list);
    }
}
