package me.joeychui.leetcode.Sword2Offer;

import me.joey.speedup.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P32_3 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> treeList = new LinkedList<>();
        LinkedList<TreeNode> cache = new LinkedList<>();
        treeList.add(root);
        boolean order = true;
        while (!treeList.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int levelSize = treeList.size(); // 一定要先记录这个值，因为size会变化
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = treeList.poll();
                if (order) {
                    // 这是是加到层的链表中，只有输出需要反序，treeList不需要
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    cache.add(node.left);
                }
                if (node.right != null) {
                    cache.add(node.right);
                }
            }
            treeList.addAll(cache);
            cache.clear();
            res.add(level);
            order = !order;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));
        List<List<Integer>> result = levelOrder(root);

    }
}
