package com.algorithms.epi.binarytree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreOrderInOrder extends AbstractBinaryTree {
    public static void main(String[] args) {
        new BinaryTreeFromPreOrderInOrder().execute();
    }

    public void execute() {
        String[] inOrderList = {"F", "B", "A", "E", "H", "C", "D", "I", "G"};
        String[] preOrderList = {"H", "B", "F", "E", "A", "C", "D", "G", "I"};
        BinaryTreeNode<Integer> treeNode = binaryTreeFromInOrderPreOrder(inOrderList, preOrderList);
        inOrderTraversal(treeNode);
        log("\n\nPre Order");
        preOrderTraversalRecursive(treeNode);
    }

    private BinaryTreeNode<Integer> binaryTreeFromInOrderPreOrder(String[] inOrderList, String[] preOrderList) {
        Map<String, Integer> inOrderIndex = new HashMap<>();
        for (int i = 0; i < inOrderList.length; i++) {
            inOrderIndex.put(inOrderList[i], i);
        }

        return binaryTreeFromInOrderPreOrderHelper(preOrderList, 0, preOrderList.length, 0, inOrderList.length, inOrderIndex);
    }

    private BinaryTreeNode<Integer> binaryTreeFromInOrderPreOrderHelper(String[] preOrderList, int preOrderStart, int preOrderEnd,
                                                                       int inOrderStart, int inOrderEnd, Map<String, Integer> inOrderIndex) {
        if (preOrderStart >= preOrderEnd || inOrderStart >= inOrderEnd) {
            return null;
        }

        int rootIdxOfInOrder = inOrderIndex.get(preOrderList[preOrderStart]);
        int leftSubtreeSize = rootIdxOfInOrder - inOrderStart;

        return new BinaryTreeNode<Integer>(preOrderList[preOrderStart],
                binaryTreeFromInOrderPreOrderHelper(preOrderList, preOrderStart + 1, preOrderStart + 1 + leftSubtreeSize,
                        inOrderStart, rootIdxOfInOrder, inOrderIndex),
                binaryTreeFromInOrderPreOrderHelper(preOrderList, preOrderStart + 1 + leftSubtreeSize,
                        preOrderEnd, rootIdxOfInOrder + 1, inOrderEnd, inOrderIndex)
                );
    }
}
