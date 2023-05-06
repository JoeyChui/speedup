package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import me.joeychui.speedup.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P43往完全二叉树添加节点 {
    // https://leetcode.cn/problems/NaqhDT/?favorite=e8X3pBZi

    TreeNode root;
    Queue<TreeNode> queue;

    public P43往完全二叉树添加节点(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
    }

    public int insert(int v) {
        queue.offer(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left == null) {
                node.left = new TreeNode(v);
                break;
            } else {
                queue.offer(node.left);
            }
            if (node.right == null) {
                node.right = new TreeNode(v);
                break;
            } else {
                queue.offer(node.right);
            }
        }
        // know 记得遍历二叉树时用完队列后要清空队列
        queue.clear();
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    // todo 方法二：二进制表示，完全二叉树如果某个节点的编号为x，那么其左子节点的编号为2x，右子节点的编号为2x+1

    public static void main(String[] args) {

    }



}
