package offer0830;

/**
 * @author: celeste
 * @create: 2020-08-30 01:18
 * @description:
 * 题目：剑指 Offer 50. 第一个只出现一次的字符
 * 描述：在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例:
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 *
 **/
public class FirstUniqChar {
    /**
     * 从第一个字符开始遍历后面是否出现过，出现就全标true
     * 后面如果是true就跳过，如果找到没有出现过的就返回这个字符
     * @param s
     * @return
     */
    public char firstUniqChar(String s){
        if (s.length() == 0) return ' ';
        if (s.length() == 1) return s.charAt(0);
        char[] chars = s.toCharArray();
        boolean[] state = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++){
            if (state[i]) continue;
            char c = chars[i];
            for (int j = i + 1; j < chars.length; j++){
                if (chars[j] == c) {
                    state[i] = true;
                    state[j] = true;
                }
            }
            if (!state[i]) return c;
        }
        return ' ';
    }

    /**
     * 另一种更加省时间的做法，因为只是出现小写字符，可以选择建立一个26大小的矩阵，
     * 然后遍历矩阵将字符存入，最后再遍历一遍，等于1就是结果，没有就返回空格
     * @param s
     * @return
     */
    public char firstUniqChar2(String s){
        char[] chars = s.toCharArray();
        int[] state = new int[26];
        for (char c : chars) state[c - 'a']++;
        //一定要按照字符遍历顺序再遍历一次才是需要的第一次出现一次的字符
        for (char c : chars){
            if (state[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
