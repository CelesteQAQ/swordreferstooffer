package offer0901;

/**
 * @author: celeste
 * @create: 2020-09-01 00:22
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
//        ReverseWords re = new ReverseWords();
//        re.reverseWords("a good   example");
        MaxSlidingWindow ma = new MaxSlidingWindow();
        ma.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},
        3);
    }
}
