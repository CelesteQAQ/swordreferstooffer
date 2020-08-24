package offer0824;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-24 01:10
 * @description:
 * 题目：剑指 Offer 38. 字符串的排列
 * 描述：输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 **/
public class Permutation {
    /**
     * 就是全排列，回溯问题
     * 每个都是从第一个开始，然后复制所有其他字符，然后生成其他的字符串
     * 然后合并，
     * @param s
     * @return
     */

    public String[] permutation(String s) {
        if (s.length() <= 1){
            return new String[]{s};
        }
        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder res = new StringBuilder();
            sb.append(s.charAt(i));
            for (int j = 0; j < s.length(); j++) {
                if (j == i) continue;
                res.append(s.charAt(j));
            }
            String[] resStr = permutation(new String(res));
            StringBuilder sb2 = new StringBuilder(sb);
            for (int k = 0; k < resStr.length; k++) {
                sb2.append(resStr[k]);
                result.add(sb2.toString());
                sb2 = sb;
            }
        }

        HashSet<String> set = new HashSet();

        for (int m = 0; m < result.size(); m++) {
            set.add(result.get(m));
        }
        String[] ans = new String[set.size()];
        int m = 0;
        for (String s1 : set) {
            ans[m++] = s1;
        }
        return ans;
    }

    public String[] permutation1(String s){
        List<String> res = new LinkedList<>();
        char[] chars = s.toCharArray();
        dfs(res, chars, 0);
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }

    private void dfs(List<String> res, char[] chars, int pos) {
        if (pos == chars.length){
            res.add(new String(chars));
        }
        for (int i = pos; i < chars.length; i++){
            boolean flag = true;
            for (int j = pos; j < i; j++) {
                if (chars[j] == chars[i]) {
                    flag = false;
                }
            }
                if (flag){
                 swap(chars, pos, i);
                 dfs(res, chars,pos+ 1);
                 swap(chars, pos, i);
                }
            }
        }

    public void swap(char[] chars, int x, int y){
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

}
