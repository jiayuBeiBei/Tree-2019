package com.jiayu.app;

public class Node{
    //Node必须是public,不然放不到list等集合框架里
      Node right=null;
      Node left=null;
    Node parent=null;
     int val=0;
    Node (int val){
        this.val=val;
    }

    public Node(Node right, Node left, Node parent, int val) {
        this.right = right;
        this.left = left;
        this.parent = parent;
        this.val = val;
    }
    //判断俩个节点想不想等,是一个比较复杂的问题,因为一个节点的子树可能有很多层


    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
