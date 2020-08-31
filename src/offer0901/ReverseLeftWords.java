package offer0901;

/**
 * @author: celeste
 * @create: 2020-09-01 00:43
 * @description:
 * 题目：剑指 Offer 58 - II. 左旋转字符串
 * 描述：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 **/
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n){
        char[] chars = s.toCharArray();
        int len = chars.length;
        char[] res = new char[len];
        //abcdefg 2  7
        for (int i = 0; i < len - n; i++){
            res[i] = chars[n + i];
        }
        int k = 0;
        for (int i = len - n; i < len; i++){
            res[i] = chars[k++];
        }
        return new String(res);
    }

    /**
     * 另一种更加简单的方法
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n){
        if (n == 0) return s;
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
