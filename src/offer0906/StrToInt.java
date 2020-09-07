package offer0906;

import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

/**
 * @author: celeste
 * @create: 2020-09-07 01:31
 * @description:
 * 题目：剑指 Offer 67. 把字符串转换成整数
 * 描述：写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
 * 则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 **/
public class StrToInt {
    /**
     * 是数字：然后一直判断是否是数字直到不是数字
     * 是+-号：然后一直判断后面是否是数字直到不是数字
     * 是字符循环（第一步
     * 无法处理超级大的数
     * @param str
     * @return
     */
    public int strToInt(String str){
        str = str.trim();
        int n = str.length();
        if (n < 1) return 0;
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        for (int i = 0; i < n; i++){
            char c = str.charAt(i++);
            if (Character.isDigit(c)){
                while (Character.isDigit(c)){
                    sb.append(c);
                    c = i < n ? str.charAt(i++) : ' ';
                }
                break;
            } else if (c == '+' || c == '-') {
                sign = c == '+' ? 1 : -1;
                c = i < n ? str.charAt(i++) : ' ';
                if (Character.isDigit(c)) {
                    while (Character.isDigit(c)) {
                        sb.append(c);
                        c = i < n ? str.charAt(i++) : ' ';
                    }
                    break;
                } else {
                    return 0;
                }
            }else{
                return 0;
            }
        }
        //long都不够
        long ans = Long.parseLong(sb.toString());
        if (sign == 1) return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)(ans)*sign;
        else return ans > Integer.MAX_VALUE ? Integer.MIN_VALUE : (int)(ans)*sign;
    }

    /**
     * 边换成数字边判断越界
     * @param str
     * @return
     */
    public int strToInt2 (String str){
        str = str.trim();
        int i = 0, ans = 0, sign = 1, len = str.length();
        if (len < 1) return 0;
        //是否是+-号
        if (str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        for (; i < len; ++i){
            int temp = str.charAt(i) - '0';
            //不是数字就跳出
            if (temp > 9 || temp < 0){
                break;
            }
            //超出数字范围
            if (ans > Integer.MAX_VALUE / 10
            || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < temp))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            //没有超范围
			else
                ans = ans * 10 + temp;
            }
            return sign * ans;

            }
}
