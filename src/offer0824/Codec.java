package offer0824;

import offer0820.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: celeste
 * @create: 2020-08-24 00:39
 * @description:
 * 题目：剑指 Offer 37. 序列化二叉树 297. 二叉树的序列化与反序列化
 * 描述：序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 示例: 
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            if (root != null){
                sb.append(root.val);
                queue.add(root.left);
                queue.add(root.right);
            }else {
                sb.append("null");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree = data.split(",");
        if (tree[0].equals("null")){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur == null){
                continue;
            }
            if (!tree[i].equals("null")){
                cur.left = new TreeNode(Integer.valueOf(tree[i]));
            }else {
                cur.left = null;
            }
            if (!tree[i + 1].equals("null")){
                cur.right = new TreeNode(Integer.valueOf(tree[i + 1]));
            }else {
                cur.right = null;
            }
            i += 2;
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return root;

    }
}
