package me.joeychui.speedup.leetcode.Sword2OfferSpecial;

import me.joeychui.speedup.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class P45二叉树最底层最左边的值 {
    // https://leetcode.cn/problems/LwUNpT/description/?favorite=e8X3pBZi

    // know 方法一：按照层广度优先遍历，记录每层第一个节点值
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        int res = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            res = queue.peek().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    // todo 看看答案的思路 https://leetcode.cn/problems/LwUNpT/solutions/1614780/er-cha-shu-zui-di-ceng-zui-zuo-bian-de-z-0nlm/


    public static void main(String[] args) {

    }
}
