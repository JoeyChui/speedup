package me.joeychui.leetcode.Sword2OfferSpecial;

import me.joey.speedup.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P44二叉树每层的最大值 {
    // https://leetcode.cn/problems/hPov7L/?favorite=e8X3pBZi

    // know 方法一：利用队列广度遍历二叉树
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!queue.isEmpty() || !level.isEmpty()) {
            if (queue.isEmpty()) {
                Queue<TreeNode> temp = new LinkedList<>(level);
                int max = temp.peek().val;
                while (!temp.isEmpty()) {
                    max = Math.max(temp.poll().val, max);
                }
                res.add(max);
                queue.addAll(level);
                level.clear();
            }
            TreeNode node = queue.poll();
            if (node.left != null) level.offer(node.left);
            if (node.right != null) level.offer(node.right);
        }
        return res;
    }

    // know 方法一的更好的写法：利用 int levelSize = queue.size();
    public List<Integer> largestValues2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelMax = queue.peek().val;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelMax = Math.max(levelMax, node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(levelMax);
        }
        return res;
    }

    // todo 看看官网解法https://leetcode.cn/problems/hPov7L/solutions/1619295/er-cha-shu-mei-ceng-de-zui-da-zhi-by-lee-q4y2/

    public static void main(String[] args) {


    }
}
