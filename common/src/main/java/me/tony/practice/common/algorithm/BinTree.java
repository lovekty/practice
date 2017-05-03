package me.tony.practice.common.algorithm;

import org.junit.Test;

/**
 * Created by tony on 2017/5/2.
 */
public class BinTree {

    static Node<Integer> root = new Node<>(1,
            new Node<>(5,
                    new Node<>(7),
                    new Node<>(4,
                            new Node<>(3),
                            new Node<>(8))),
            new Node<>(6,
                    new Node<>(3,
                            new Node<>(5),
                            null),
                    new Node<>(6)));

    public int sum(int base, Node<Integer> node) {
        int ret = base + node.value;
        int lRet, rRet;
        lRet = rRet = 0;
        boolean flag = false;
        if (node.left != null) {
            lRet = sum(ret * 10, node.left);
            flag = true;
        }
        if (node.right != null) {
            rRet = sum(ret * 10, node.right);
            flag = true;
        }
        if (flag) {
            return lRet + rRet;
        }
        return ret;
    }

    @Test
    public void sum() {
        int sum = sum(0, root);
        System.out.println(sum);
    }

}

class Node<T> {
    Node<T> left;
    Node<T> right;
    T value;


    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
