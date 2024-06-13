package com.echo.datastructure.storestructure.tree;

/**
 * 二叉树：
 *
 * 二分搜索树：
 * - 添加
 * - 查询
 * - 删除（最大值、最小值、任意值）
 * - 遍历（前中后序遍历）
 * */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private static class Node<E> {
        public E e;
        public Node<E> left;
        public Node<E> right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        public Node(E e, Node<E> left, Node<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

    }

}
