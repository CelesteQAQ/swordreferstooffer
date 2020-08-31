package offer0901;

/**
 * @author: celeste
 * @create: 2020-09-01 00:12
 * @description:
 * 题目：剑指 Offer 58 - I. 翻转单词顺序
 * 描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 **/
public class ReverseWords {
    public String reverseWords (String s){
        s = s.trim();
        //String[] words = s.split("\\s+");时间会变慢很多7ms
        String[] words = s.split(" ");//时间是1ms
        int n = words.length;
        StringBuilder newWords = new StringBuilder();
        for (int i = 0; i < n; i++){
            if(!words[n - 1 - i].equals("")){
                newWords.append(words[n - 1 - i]);
                newWords.append(" ");
            }
        }
        return newWords.toString().trim();
    }
}
