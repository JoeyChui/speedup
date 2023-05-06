package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P46二叉树的右侧视图 {
    // https://leetcode.cn/problems/WNC0Lk/?favorite=e8X3pBZi

    // know 方法一：按层广度优先遍历，记录每层最后一个节点值
    // know 优化：采用先右后左的层序遍历，可以不用Deque
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            res.add(deque.peekLast().val);
            int levelSize = deque.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return res;
    }

    // todo 看看答案思路 https://leetcode.cn/problems/WNC0Lk/solutions/1398945/er-cha-shu-de-you-ce-shi-tu-by-leetcode-ucmya/

    public static void main(String[] args) {

    }
}
