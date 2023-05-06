package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.TreeNode;

public class P54所有大于等于节点的值之和 {
    // https://leetcode.cn/problems/w6cpku/description/?favorite=e8X3pBZi

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        // 走路：进
        convertBST(root.right);
        // 走路：退
        // 操作：
        sum += root.val;
        root.val = sum;
        // 走路：进
        convertBST(root.left);
        // 走路：退
        return root;
    }

    public static void main(String[] args) {

    }
}
