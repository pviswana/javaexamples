package com.algorithms.epi.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PreOrderTraversalWithoutRecursion extends AbstractBinaryTree {
    public static void main(String[] args) {
        new PreOrderTraversalWithoutRecursion().execute();
    }

    public void execute() {
        super.initializeTree();
        preOrderTraversal(treeNode);
    }

    private void preOrderTraversal(BinaryTreeNode<Integer> treeNode) {
        Deque<BinaryTreeNode<Integer>> path = new ArrayDeque<>();
        ArrayList<BinaryTreeNode<Integer>> result = new ArrayList<>();
        BinaryTreeNode<Integer> currNode = treeNode;

        if (treeNode != null) {
            path.addFirst(currNode);
        }

        while(!path.isEmpty()) {
            currNode = path.removeFirst();
            result.add(currNode);

            if (currNode.right != null) {
                path.addFirst(currNode.right);
            }

            if (currNode.left != null) {
                path.addFirst(currNode.left);
            }
        }

        for (BinaryTreeNode<Integer> node : result) {
            log(node.identifier + ",");
        }
    }
}
