package offer0908;

import offer0820.TreeNode;

/**
 * @author: celeste
 * @create: 2020-09-08 02:15
 * @description:
 * 题目：剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 描述：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 **/
public class LowestCommonAncestor {
    /**
     * II. 二叉树的最近公共祖先
     * 不小心把二叉树先做了
     * 左右子树去查找是否找到pq
     * 第一，根节点是否为pq，是就返回根节点
     * 第二，不是，就遍历左右子树，左子树存在就返回，右子树返回是没有就是左子树返回的值
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowerCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowerCommonAncestor(root.left, p, q);
        TreeNode right = lowerCommonAncestor(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    /**
     * 上面没有利用到二叉搜索树的性质，左子树全部小于根节点，右子树全部大于根节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (pVal >parentVal && qVal > parentVal){
            return lowestCommonAncestor(root.right, p, q);
        }else if (pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return root;
        }
    }
}
