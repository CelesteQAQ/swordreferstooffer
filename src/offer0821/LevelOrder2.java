package offer0821;

import offer0820.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: celeste
 * @create: 2020-08-22 00:53
 * @description:
 * 题目：剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 描述：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 **/
public class LevelOrder2 {
    public List<List<Integer>> levelOrder2(TreeNode root){
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < len; i++){
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(temp);
        }
        return result;
    }

}
