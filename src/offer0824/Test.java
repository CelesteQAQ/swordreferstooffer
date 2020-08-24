package offer0824;

import offer0825.MedianFinder;

/**
 * @author: celeste
 * @create: 2020-08-24 01:42
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
//        Permutation pe = new Permutation();
//        pe.permutation1("abc");
        MedianFinder me = new MedianFinder();
        me.addNum(-1);
        me.addNum(-2);
        double i = me.findMedian();
        me.addNum(-3);
        me.findMedian();
    }
}
