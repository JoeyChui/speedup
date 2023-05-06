package me.joeychui.leetcode.Sword2Offer;

import me.joey.speedup.leetcode.util.TreeNode;

public class P26 {

    static public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return preorder(A, B);
    }

    static boolean preorder(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (A.val == B.val && check(A, B)) {
            return true;
        }
        return preorder(A.left, B) || preorder(A.right, B);
    }

    static boolean check(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A != null && B == null) {
            return true;
        } else if (A == null && B != null) {
            return false;
        }
//            if (A == null || B == null) {
//            不要忘了这种有一个是null的情况，还会导致下面NPE，有（A == null && B == null） 就要记得（A == null || B == null）
        if (A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode in1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        TreeNode in2 = new TreeNode(3);
        boolean out = isSubStructure(in1, in2);

        in1 = new TreeNode(1, new TreeNode(0, new TreeNode(-4), new TreeNode(-3)), new TreeNode(1));
        in2 = new TreeNode(1, new TreeNode(-4), null);
        out = isSubStructure(in1, in2);

        in1 = new TreeNode(10, new TreeNode(12, new TreeNode(8, new TreeNode(11), null), new TreeNode(3)), new TreeNode(6));
        in2 = new TreeNode(10, new TreeNode(12, new TreeNode(8), null), new TreeNode(6));
        out = isSubStructure(in1, in2);

    }
}
