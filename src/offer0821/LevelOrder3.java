package offer0821;

import offer0820.TreeNode;

import java.util.*;

/**
 * @author: celeste
 * @create: 2020-08-22 01:00
 * @description:
 * 题目：剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 描述：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 **/
public class LevelOrder3 {
    /**
     * 就是进栈的顺序变了？
     * 3
     * 9 20
     * 7 15
     * 奇数是从右子树开始进栈，偶数是从左子树开始进栈
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root){
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> temp = new LinkedList<>();
            level++;
            for (int i = 0; i < len; i++){
                TreeNode cur = queue.poll();
                //注意这段是偶数层从头插入，奇数层从尾插入
                if (level % 2 == 0){
                    temp.add(0, cur.val);
                }else {
                    temp.add(cur.val);
                }

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(temp);
        }
        return result;
    }
}
