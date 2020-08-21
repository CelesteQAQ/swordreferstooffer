package offer0821;

import offer0820.TreeNode;

/**
 * @author: celeste
 * @create: 2020-08-22 01:16
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        LevelOrder3 le = new LevelOrder3();
        le.levelOrder3(node);
    }
}
