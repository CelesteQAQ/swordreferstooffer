package offer0821;

import offer0820.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: celeste
 * @create: 2020-08-21 11:16
 * @description:
 * 题目：剑指 Offer 32 - I. 从上到下打印二叉树
 * 描述：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 **/
public class LevelOrder {
    /**
     * 层遍历二叉树，那使用队列吗？
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                TreeNode cur = queue.poll();
                result.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
