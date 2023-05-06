package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import me.joeychui.speedup.leetcode.util.TreeNode;

public class P47二叉树剪枝 {
    // https://leetcode.cn/problems/pOCWxh/?favorite=e8X3pBZi

    // know 方法一：递归深度优先遍历
    public TreeNode pruneTree(TreeNode root) {
        if (traversalTree(root)) {
            return null;
        }
        return root;
    }

    boolean traversalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = traversalTree(root.left);
        if (left) {
            root.left = null;
        }
        boolean right = traversalTree(root.right);
        if (right) {
            root.right = null;
        }
        return  root.val == 0 && left && right;
    }

    // todo 看看官方题解 https://leetcode.cn/problems/pOCWxh/solutions/1683847/er-cha-shu-jian-zhi-by-leetcode-solution-r0cg/


    public static void main(String[] args) {

    }
}
