package com.algorithms.epi.binarytree;

public abstract class AbstractBinaryTree {
    protected BinaryTreeNode<Integer> treeNode = null;

    public class BinaryTreeNode<T> {
        T data;
        String identifier;
        BinaryTreeNode<T> left, right;
    }

    public void initializeTree() {
        treeNode = new BinaryTreeNode<Integer>();
        treeNode.data = 1;
        treeNode.identifier = "A";

        treeNode.left = new BinaryTreeNode<Integer>();
        ;
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
    }

    public void log(String s) {
        System.out.println(s);
    }
}
