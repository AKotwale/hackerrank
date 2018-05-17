package com.hackerrank.lib;

public class BinaryTree {

    BiNode rootNode;

    BinaryTree(int data, BiNode leftNode, BiNode rightNode) {
        rootNode = new BiNode(data, leftNode, rightNode);
    }

    static class BiNode {
        int data;
        BiNode leftNode;
        BiNode rightNode;

        BiNode(int data, BiNode leftNode, BiNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    static class Result {
        int result;
        boolean isBinaryTree;

        Result(int result, boolean isBS) {
            this.result = result;
            this.isBinaryTree = isBS;
        }

    }

    enum TreeTypes {
        ROOT, LEFT_SUBTREE, RIGHT_SUBTREE;
    }

    public static Result isBinaryTree(TreeTypes type, BiNode node) {
        Result leftResult;
        Result rightResult;

        if (node.rightNode != null) {
            rightResult = isBinaryTree(TreeTypes.RIGHT_SUBTREE, node.rightNode);
            if (node.leftNode == null) {
                if (rightResult.result > node.data) {
                    switch (type) {
                        case LEFT_SUBTREE:
                            return new Result(rightResult.result, true);
                        case RIGHT_SUBTREE:
                            return new Result(node.data, true);
                        case ROOT:
                            return new Result(0, true);
                            default:
                                return new Result(0, false);
                    }
                } else {
                    return new Result(0, false);
                }
            } else {
                leftResult = isBinaryTree(TreeTypes.LEFT_SUBTREE, node.leftNode);
                if (rightResult.result > node.data && leftResult.result < node.data) {
                    switch (type) {
                        case LEFT_SUBTREE:
                            return new Result(rightResult.result, true);
                        case RIGHT_SUBTREE:
                            return new Result(leftResult.result, true);
                        case ROOT:
                            return new Result(0, true);
                        default:
                            return new Result(0, false);
                    }
                } else {
                    return new Result(0, false);
                }
            }
        } else {
            if (node.leftNode == null) {
                 return  new Result(node.data, true);
            } else {
                leftResult = isBinaryTree(TreeTypes.LEFT_SUBTREE, node.leftNode);
                if (leftResult.result < node.data) {
                    switch (type) {
                        case LEFT_SUBTREE:
                            return new Result(node.data, true);
                        case RIGHT_SUBTREE:
                            return new Result(leftResult.result, true);
                        case ROOT:
                            return new Result(0, true);
                        default:
                            return new Result(0, false);
                    }
                } else {
                    return new Result(0, false);
                }
            }
        }
    }
}


