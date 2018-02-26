package com.algorithms.epi.binarytree;

public class SumRootToLeaf95 {
    private class BinaryTreeNode<T> {
        T data;
        String identifier;
        BinaryTreeNode<T> left, right;
    }

    public static void main(String[] args) {
        SumRootToLeaf95 sumRootToLeaf95 = new SumRootToLeaf95();
        sumRootToLeaf95.execute();
    }

    public void execute() {
        BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<Integer>();
        treeNode.data = 1;
        treeNode.identifier = "A";

        treeNode.left = new BinaryTreeNode<Integer>();;
        treeNode.left.data = 0;
        treeNode.left.identifier = "B";

        treeNode.left.left = new BinaryTreeNode<>();
        treeNode.left.left.data = 0;
        treeNode.left.left.identifier = "C";

        treeNode.left.left.left = new BinaryTreeNode<>();
        treeNode.left.left.left.data = 0;
        treeNode.left.left.left.identifier = "D";

        treeNode.left.left.right = new BinaryTreeNode<>();
        treeNode.left.left.right.data = 1;
        treeNode.left.left.right.identifier = "E";

        treeNode.left.right = new BinaryTreeNode<>();
        treeNode.left.right.data = 1;
        treeNode.left.right.identifier = "F";

        treeNode.left.right.right = new BinaryTreeNode<>();
        treeNode.left.right.right.data = 1;
        treeNode.left.right.right.identifier = "G";

        treeNode.left.right.right.left = new BinaryTreeNode<>();
        treeNode.left.right.right.left.data = 0;
        treeNode.left.right.right.left.identifier = "H";

        treeNode.right = new BinaryTreeNode<>();
        treeNode.right.data = 1;
        treeNode.right.identifier = "I";

        treeNode.right.left = new BinaryTreeNode<>();
        treeNode.right.left.data = 0;
        treeNode.right.left.identifier = "J";

        treeNode.right.left.right = new BinaryTreeNode<>();
        treeNode.right.left.right.data = 0;
        treeNode.right.left.right.identifier = "K";

        treeNode.right.left.right.left = new BinaryTreeNode<>();
        treeNode.right.left.right.left.data = 1;
        treeNode.right.left.right.left.identifier = "L";

        treeNode.right.left.right.left.right = new BinaryTreeNode<>();
        treeNode.right.left.right.left.right.data = 1;
        treeNode.right.left.right.left.right.identifier = "M";

        treeNode.right.left.right.right = new BinaryTreeNode<>();
        treeNode.right.left.right.right.data = 0;
        treeNode.right.left.right.right.identifier = "N";

        treeNode.right.right = new BinaryTreeNode<>();
        treeNode.right.right.data = 0;
        treeNode.right.right.identifier = "O";

        treeNode.right.right.right = new BinaryTreeNode<>();
        treeNode.right.right.right.data = 0;
        treeNode.right.right.right.identifier = "P";

        inOrderTraversal(treeNode);
        log("\n\nSum Root to Leaf:");
        sumRootToLeaf(treeNode);
    }

    private void inOrderTraversal(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return;
        }

        inOrderTraversal(tree.left);
        log(tree.identifier + "=" + tree.data);
        inOrderTraversal(tree.right);
    }

    private void sumRootToLeaf(BinaryTreeNode<Integer> tree) {
        int total =  sumRootToLeafHelper(tree, 0);
        log("\nTotal = " + total);
    }

    private int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialPathSum) {
        if (tree == null) {
            return 0;
        }

        partialPathSum = partialPathSum * 2 + tree.data;

        if (tree.left == null && tree.right == null) {
            log(tree.identifier + "(leaf) = " + partialPathSum);
            return partialPathSum;
        }

        log(tree.identifier + "(non-leaf) = " + partialPathSum);
        return sumRootToLeafHelper(tree.left, partialPathSum) + sumRootToLeafHelper(tree.right, partialPathSum);
    }

    private void log(String s) {
        System.out.println(s);
    }
}
