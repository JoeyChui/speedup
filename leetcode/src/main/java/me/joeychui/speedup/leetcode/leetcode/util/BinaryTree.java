package me.joeychui.leetcode.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
    // 前中后序遍历都是深度优先搜索DFS（无论迭代还是递归）
//1.前序遍历：a. 访问根节点。 b. 前序遍历左子树。 c. 前序遍历右子树。
//2.中序遍历：a. 中序遍历左子树。 b. 访问根节点。 c. 中序遍历右子树。
//3.后序遍历：a. 后序遍历左子树。 b. 后序遍历右子树。 c. 访问根节点。

// 前中后序遍历分别是：根在前中后，左右顺序始终不变
// 以上三种遍历方式都可以使用递归或迭代的方式实现。其中，递归实现比较简单，但对于非常大的树可能会导致栈溢出，因此对于大树来说，迭代实现可能更好。
// 迭代实现的方法是使用一个栈（即深度优先搜索），先将根节点压入栈中，然后不断从栈中弹出节点，并将其右子节点和左子节点压入栈中，直到栈为空为止。

    // 前中后序遍历调用
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    // 前序遍历-递归
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 中序遍历-递归
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    // 后序遍历-递归
    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 前序遍历-迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right); // 先入栈右节点
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    // 中序遍历-迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // 遍历到最左边的节点，并将沿途经过的节点全部压入栈中
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 取出栈顶元素，并加入结果列表
            current = stack.pop();
            res.add(current.val);
            // 遍历右子树
            current = current.right;
        }
        return res;
    }

    // 后序遍历-迭代
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return res;
    }


    // 复制二叉树-递归
    public TreeNode copyBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = copyBinaryTree(root.left);
        node.right = copyBinaryTree(root.right);
        return node;
    }

    // 插入二叉树-递归
    private TreeNode insertNode(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.val) {
            node.left = insertNode(node.left, value);
        } else if (value > node.val) {
            node.right = insertNode(node.right, value);
        }
        return node;
    }


}
