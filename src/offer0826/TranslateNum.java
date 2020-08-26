package offer0826;

/**
 * @author: celeste
 * @create: 2020-08-26 14:20
 * @description:
 * 题目：剑指 Offer 46. 把数字翻译成字符串
 * 描述：给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 **/
public class TranslateNum {
    /**
     * 还是动态规划
     * 求得是次数，不是字符的集合，就不需要换算成字符串
     * 将num换成字符串处理
     * 然后判断i 与 i+1的组合是否小于26，小于就是有2种方式，现在i + 1的次数就是i - 1的次数 + 2
     *或者是分开2种按照i单独
     * 1 2 2 5 8
     * 1     --1
     * 1 2   --1 + 1
     * 1 2 2  --1 + 2
     * 1 2 2 5  -- 2 + 3
     * @param num
     * @return
     */
    public int translateNum(int num){
        String s = String.valueOf(num);
        int len = s.length();
        if (len <= 1) return 1;
        int[] state = new int[len + 1];
        //小于9的其实都是返回1
        state[0] = 1;
        state[1] = 1;
        for (int i = 1; i < len; i++){
            // 存在2种情况的数字情况
            if (Integer.parseInt(s.substring(i - 1, i + 1)) < 26
                    && Integer.parseInt(s.substring(i - 1, i + 1)) > 9){
                state[i + 1] = state[i - 1] + state[i];
                //跟前面的情况一样
            }else {
                state[i +  1] = state[i];
            }
        }
        return state[len];
    }

    /**
     * 评论的另一种不需要将数字转换成字符串的处理方式
     * @param num
     * @return
     */
    public int translateNum2(int num){
        if (num < 10) return 1;
        if (num % 100 < 26 && num % 100 > 9){
            return translateNum2(num / 10) + translateNum2(num / 100);
        }else {
            return translateNum2(num / 10);
        }
    }
}
