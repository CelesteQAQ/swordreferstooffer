package offer0818;

/**
 * @author: celeste
 * @create: 2020-08-18 13:17
 * @description:
 * 题目：剑指 Offer 19. 正则表达式匹配
 * 描述：
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 **/
public class IsMatch {
    /**
     * 动态规划的思路是对的，但是是二维的，不是一维
     * 需要初始化p的字符串，因为如果是.是可以为0个，主要是初始化这个
     * 然后判断是否是s字符跟p字符一致或者p字符是.，如果一致就取决于没有的时候的状态
     * 如果p的字符是*，那么一致就是取决于s字符是否与*号前面的字符或者.是否一致，
     * 以及与*以及前面的字符再前面一个比较的结果相比，相同就是返回真，不同就是false
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p){
        int s_len = s.length();
        int p_len = p.length();
        // 建立一个二维的数组
        boolean[][] state = new boolean[s_len + 1][p_len + 1];
        state[0][0] = true;
        // 对第一行的数组进行初始化，指的是*情况
        for (int i = 1; i < p_len + 1; i++){
            if (p.charAt(i - 1) == '*'){
                state[0][i] = state[0][i - 2];
            }else {
                state[0][i] = false;
            }
        }

        for (int i = 1; i < s_len + 1; i++){
            for (int j = 1; j < p_len + 1; j++){
                char str_s = s.charAt(i - 1);
                char str_p = p.charAt(j - 1);
                // 是相同或者是.都是取决于前一个字符的判断情况
                if (str_p == str_s || str_p == '.'){
                    state[i][j] = state[i - 1][j - 1];
                    // 是*号就是先考虑没有就是看前2个字符是否相同（不考虑第一个字符就是*情况）
                }else if (str_p == '*'){
                    state[i][j] = state[i][j - 2];
                    char str_p_pre = p.charAt(j - 2);
                    //然后判断字符串是否是一样的或者是.
                    if (str_s == str_p_pre || str_p_pre == '.'){
                        state[i][j] = state[i][j] || state[i - 1][j];
                    }else {
                        state[i][j] = false;
                    }
                }
            }
        }
        return state[s_len][p_len];

    }
}
