package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P48序列化与反序列化二叉树 {
    // https://leetcode.cn/problems/h54YBf/?favorite=e8X3pBZi

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "null";
        // todo 学习使用StringBuilder String.join()
        StringBuilder res = new StringBuilder(String.valueOf(root.val));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                res.append(",").append(node.left.val);
            } else {
                res.append(",").append("null");
            }
            if (node.right != null) {
                queue.offer(node.right);
                res.append(",").append(node.right.val);
            } else {
                res.append(",").append("null");
            }
        }
        String resStr = res.toString();
        while (resStr.endsWith(",null")) {
            resStr = res.substring(0, resStr.length() - ",null".length());
        }
        return resStr;
    }

    // know List.toString()结果是什么？"["1", "2", "null", "4"]"

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        String[] tree = data.split(",");
        // parseInt 和 valueOf 有什么区别
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        queue.offer(root);
        for (int i = 1; i < tree.length;) {
            TreeNode node = queue.poll();
            if (tree[i].equals("null")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(node.left);
            }
            i++;
            if (i >= tree.length) break;
            if (tree[i].equals("null")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(tree[i]));
                queue.offer(node.right);
            }
            i++;
            if (i >= tree.length) break;
        }
        return root;
    }

    // todo list 遍历, array to list:Arrays.asList()

    public static void main(String[] args) {
        TreeNode in = new TreeNode(1, new TreeNode(2),null);
        String ser = serialize(in);
        TreeNode out = deserialize(ser);

    }
}
