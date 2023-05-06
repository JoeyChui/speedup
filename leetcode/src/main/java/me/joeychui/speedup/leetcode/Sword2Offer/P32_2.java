package me.joeychui.speedup.leetcode.Sword2Offer;

import me.joeychui.speedup.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P32_2 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> treeList = new LinkedList<>();
        treeList.add(root);
        while (!treeList.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int levelSize = treeList.size(); // 一定要先记录这个值，因为size会变化
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = treeList.poll();
                level.add(node.val);
                if (node.left != null) {
                    treeList.add(node.left);
                }
                if (node.right != null) {
                    treeList.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = levelOrder(root);

    }
}
