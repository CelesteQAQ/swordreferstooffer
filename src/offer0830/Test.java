package offer0830;

import com.sun.source.tree.Tree;

/**
 * @author: celeste
 * @create: 2020-08-30 17:14
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
//        Search se = new Search();
//        se.search2(new int[]{5,7,7,8,8,10}, 8);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;
        IsBalanced is = new IsBalanced();
        is.isBalanced(node1);
    }
}
