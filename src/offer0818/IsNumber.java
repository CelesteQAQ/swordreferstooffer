package offer0818;

/**
 * @author: celeste
 * @create: 2020-08-18 19:38
 * @description:
 * 题目：剑指 Offer 20. 表示数值的字符串
 * 描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 **/
public class IsNumber {
    /**
     * 注意从前面开始看
     * +-号可以出现在第一位或者e后
     * 数字判断
     * .符号只可以出现在数字后（可以不出现在数字后）并且没有出现e/E
     * e出现后后面数字不可以出现.
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        boolean num = false;
        boolean dot = false;
        boolean eE = false;
        for (int i = 0; i < s.length(); i++){
            //判断数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                num = true;
                //.符号只要前面没有出现过并且没有出现过e就可以
            }else if (s.charAt(i) == '.' && !eE && !dot){
                dot = true;
                //eE符号只要前面没有出现过并且前面有数字
            }else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && num && !eE){
                eE = true;
                num = false;
                //+-符号只可以出现在第一位以及e的后面
            }else if ((s.charAt(i) == '+' || s.charAt(i) == '-') &&
                    (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')){
                //其他情况都是false
            } else {
                return false;
            }
        }
        //返回值是num，因为其他可以不出现，但是所有都是需要必须出现过num，其他都是标记
        return num;
    }
}
