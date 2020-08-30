package offer0830;

import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-08-30 19:45
 * @description:
 * 题目：剑指 Offer 55 - I. 二叉树的深度
 * 描述：输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 **/
public class MaxDepth {
    /**
     * 树的高度就是左右子树中最大的高度加上1
     * 初始化所有为null的高度为1
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 需要使用非递归的方式来做一次
     * 这个非递归是从根节点到叶子节点遍历
     * 每层加一
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        if (root == null) return 0;
        else {
            stack.push(root);
            map.put(root, 1);
        }
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            //可以在这里比较最大值
            //max = Math.max(max, map.get(cur));
            //这个遍历没有要求顺序
            if (cur.left != null) {
                stack.push(cur.left);
                //深度直接就是父节点的深度加一
                map.put(cur.left, map.get(cur) + 1);
            }
            if (cur.right != null){
                stack.push(cur.right);
                map.put(cur.right, map.get(cur) + 1);
            }
        }
        int max = 0;
        //这个最大值可以在加入的时候比较，不需要再遍历一次
        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()){
            max = Math.max(entry.getValue(), max);
        }

        return max;
    }
}
