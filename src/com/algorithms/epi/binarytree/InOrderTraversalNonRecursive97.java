package com.algorithms.epi.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversalNonRecursive97 extends AbstractBinaryTree {
    public static void main(String[] args) {
        new InOrderTraversalNonRecursive97().execute();
    }

    public void execute() {
        super.initializeTree();
        inOrderTraversal(treeNode);
    }

    public void inOrderTraversal(BinaryTreeNode<Integer> tree) {
        Deque<BinaryTreeNode<Integer>> s = new ArrayDeque<>();
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();
        BinaryTreeNode<Integer> curr = tree;

        while(!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.addFirst(curr);
                curr = curr.left;
            } else {
                curr = s.removeFirst();
                result.add(curr);
                curr = curr.right;
            }
        }

        for (BinaryTreeNode<Integer> node : result) {
            log(node.identifier + ",");
        }
    }
}
