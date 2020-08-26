package offer0826;

import java.util.HashMap;

/**
 * @author: celeste
 * @create: 2020-08-26 15:26
 * @description:
 * 题目：剑指 Offer 48. 最长不含重复字符的子字符串
 * 描述：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 **/
public class LengthOfLongestSubstring {
    /**
     * 典型的字符串匹配问题
     * 但是匹配过程遇到已经出现过的字符是使用set来判断?
     * 然后remove第一个继续加入？需要记下出现的位置，前面的全部去掉
     * 继续遍历
     * 是使用滑动窗口的方法
     * 左右指针，右边指针扩张直到遇到相同的字符，左边指针收缩直到去掉重复的字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return 1;
        int left = 0, right = 0, ansMax = 0;
        int len = s.length();
        int[] map = new int[256];
        while (right < len){
            //右指针扩张
            char c = s.charAt(right);
            map[c]++;
            right++;
            if (map[c] > 1){
                //更新窗口值
                ansMax = Math.max(ansMax, right - left - 1);
                while (map[c] > 1){
                    //左指针收缩
                    map[s.charAt(left)]--;
                    left++;
                }
            }
        }
        return Math.max(ansMax, right - left);
    }
}
