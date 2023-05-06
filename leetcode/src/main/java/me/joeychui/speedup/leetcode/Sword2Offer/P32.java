package me.joeychui.speedup.leetcode.Sword2Offer;

import me.joeychui.speedup.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P32 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        List<TreeNode> nodes = new ArrayList();
        nodes.add(root);
        List<Integer> res = new ArrayList();

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove(0);
            res.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        int[] resArray = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    public static void main(String[] args) {

    }
}
