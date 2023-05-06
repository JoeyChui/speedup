package me.joeychui.leetcode.Sword2Offer;

import me.joey.speedup.leetcode.util.TreeNode;

public class P27 {

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
    }
}
