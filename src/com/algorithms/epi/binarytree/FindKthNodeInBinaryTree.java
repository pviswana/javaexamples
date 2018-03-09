package com.algorithms.epi.binarytree;

public class FindKthNodeInBinaryTree extends AbstractBinaryTree {
    public static void main(String[] args) {
        new FindKthNodeInBinaryTree().execute();
    }

    public void execute() {
        super.initializeTree();
        //findKthNode(treeNode);
    }

    public BinaryTreeNode<Integer> findKthNode(BinaryTreeNode<Integer> tree, int k) {
        BinaryTreeNode<Integer> iter = tree;
        while (iter != null) {
            int leftSize = iter.left != null ?  iter.left.count : 0;
            if (leftSize + 1 < k) {
                k -= leftSize + 1;
                iter = iter.right;
            } else if (leftSize + 1 == k) {
                return iter;
            } else {
                iter = iter.left;
            }
        }
        return null;
    }
}
