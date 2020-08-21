package offer0821;

import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-08-21 10:45
 * @description:
 * 题目：剑指 Offer 31. 栈的压入、弹出序列
 * 描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 **/
public class ValidateStackSequences {
    /**
     * 是将pushed的重新入栈，跟弹出元素一样就弹出，并且弹出元素移动，一直到最后如果栈为空就是正确的队列
     * 不为空就是不正确的队列
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushStack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++){
            pushStack.push(pushed[i]);
            while (!pushStack.isEmpty() && pushStack.peek() == popped[j]){
                pushStack.pop();
                j++;
            }
        }
        return pushStack.isEmpty();

    }
}
