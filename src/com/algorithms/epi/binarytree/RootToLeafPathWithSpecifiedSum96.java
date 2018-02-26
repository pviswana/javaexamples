package com.algorithms.epi.binarytree;

public class RootToLeafPathWithSpecifiedSum96 {
    private class BinaryTreeNode<T> {
        T data;
        String identifier;
        BinaryTreeNode<T> left, right;
    }

    public static void main(String[] args) {
        RootToLeafPathWithSpecifiedSum96 rootToLeafPAthWithSpecifiedSum96 = new RootToLeafPathWithSpecifiedSum96();
        rootToLeafPAthWithSpecifiedSum96.execute();
    }

    public void execute() {
        BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<Integer>();
        treeNode.data = 1;
        treeNode.identifier = "A";

        treeNode.left = new BinaryTreeNode<Integer>();;
        treeNode.left.data = 2;
        treeNode.left.identifier = "B";

        treeNode.left.left = new BinaryTreeNode<>();
        treeNode.left.left.data = 3;
        treeNode.left.left.identifier = "C";

        treeNode.left.left.left = new BinaryTreeNode<>();
        treeNode.left.left.left.data = 4;
        treeNode.left.left.left.identifier = "D";

        treeNode.left.left.right = new BinaryTreeNode<>();
        treeNode.left.left.right.data = 5;
        treeNode.left.left.right.identifier = "E";

        treeNode.left.right = new BinaryTreeNode<>();
        treeNode.left.right.data = 6;
        treeNode.left.right.identifier = "F";

        treeNode.left.right.right = new BinaryTreeNode<>();
        treeNode.left.right.right.data = 7;
        treeNode.left.right.right.identifier = "G";

        treeNode.left.right.right.left = new BinaryTreeNode<>();
        treeNode.left.right.right.left.data = 8;
        treeNode.left.right.right.left.identifier = "H";

        treeNode.right = new BinaryTreeNode<>();
        treeNode.right.data = 9;
        treeNode.right.identifier = "I";

        treeNode.right.left = new BinaryTreeNode<>();
        treeNode.right.left.data = 10;
        treeNode.right.left.identifier = "J";

        treeNode.right.left.right = new BinaryTreeNode<>();
        treeNode.right.left.right.data = 11;
        treeNode.right.left.right.identifier = "K";

        treeNode.right.left.right.left = new BinaryTreeNode<>();
        treeNode.right.left.right.left.data = 12;
        treeNode.right.left.right.left.identifier = "L";

        treeNode.right.left.right.left.right = new BinaryTreeNode<>();
        treeNode.right.left.right.left.right.data = 13;
        treeNode.right.left.right.left.right.identifier = "M";

        treeNode.right.left.right.right = new BinaryTreeNode<>();
        treeNode.right.left.right.right.data = 14;
        treeNode.right.left.right.right.identifier = "N";

        treeNode.right.right = new BinaryTreeNode<>();
        treeNode.right.right.data = 15;
        treeNode.right.right.identifier = "O";

        treeNode.right.right.right = new BinaryTreeNode<>();
        treeNode.right.right.right.data = 16;
        treeNode.right.right.right.identifier = "P";

        inOrderTraversal(treeNode);
        log("\n\nSum Root to Leaf:");
        pathSum(treeNode);
        int pathSum = 24;
        boolean foundLeaf = hasPathSum(treeNode, pathSum, "");
        log("Found leaf with total = " + pathSum + "; " + foundLeaf);
    }

    private boolean hasPathSum(BinaryTreeNode<Integer> tree, int remainingWeight, String path) {
        if (tree == null) {
            return false;
        }

        path = path + (path.length() == 0 ? "" : ",") + tree.identifier;
        if (tree.left == null && tree.right == null) {
            if (remainingWeight == tree.data) {
                log(path);
            }
            return true;
        }

        return hasPathSum(tree.left, remainingWeight - tree.data, path) ||
                hasPathSum(tree.right, remainingWeight - tree.data, path );
    }

    private void inOrderTraversal(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return;
        }

        inOrderTraversal(tree.left);
        log(tree.identifier + "=" + tree.data);
        inOrderTraversal(tree.right);
    }

    private void pathSum(BinaryTreeNode<Integer> tree) {
        int total =  pathSumHelper(tree, 0);
        log("\nTotal = " + total);
    }

    private int pathSumHelper(BinaryTreeNode<Integer> tree, int partialPathSum) {
        if (tree == null) {
            return 0;
        }

        partialPathSum = partialPathSum + tree.data;

        if (tree.left == null && tree.right == null) {
            log(tree.identifier + "(leaf) = " + partialPathSum);
            return partialPathSum;
        }

        log(tree.identifier + "(non-leaf) = " + partialPathSum);
        return pathSumHelper(tree.left, partialPathSum) + pathSumHelper(tree.right, partialPathSum);
    }

    private void log(String s) {
        System.out.println(s);
    }
}

