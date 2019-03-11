package com.jiayu;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public class Node{
        //Node必须是public,不然放不到list等集合框架里
        private  Node right=null;
        private  Node left=null;
        private Node parent=null;
        private  int val=0;
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
    }
    Node root=null;


    private int preOrder(){
        List<Node> stack=new LinkedList<>();
        Node p=this.root;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                System.out.println(p.val);
                stack.add(p);
                System.out.println(p.val);
                p=p.left;
            }
            if (!stack.isEmpty()){
                    Node temp=stack.remove(stack.size()-1);
                    p=temp.right;

            }

        }
        return 0;
    }
    public static void main(String[] args) {
        Main tree=new Main();
            tree.add(0);
            tree.add(1);
            tree.add(2);
            tree.add(3);
            tree.preOrder();
        System.out.println("Hello World!");
    }
}
