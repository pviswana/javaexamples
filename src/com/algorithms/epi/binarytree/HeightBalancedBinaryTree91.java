package com.algorithms.epi.binarytree;

public class HeightBalancedBinaryTree91 {
    private class BalanceStatusWithHeight {
        private boolean balanced;
        private int height;
        public BalanceStatusWithHeight(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    private class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left, right;
    }

    public static void main(String[] args) {
        new HeightBalancedBinaryTree91().execute();
    }

    public void execute() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>();
        tree.data = 1;

        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        for (int i = 2; i < 8; i++) {
            left = new BinaryTreeNode<>();
            left.data = i;

        }
        tree.left.data = 2;
    }

    private <T> BalanceStatusWithHeight checkBalance(BinaryTreeNode<T> node) {
        return null;
    }
}
