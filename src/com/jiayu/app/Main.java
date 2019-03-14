package com.jiayu.app;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public Node root=null;

    public Main(Node root) {
        this.root = root;
    }

    //第二种方法
    private int preOrder2(){
        List<Node> stack=new LinkedList<Node>();
        Node point=root;
        ((LinkedList<Node>) stack).push(point);
        while(!stack.isEmpty()){
            Node temp=((LinkedList<Node>) stack).pop();
            System.out.println(temp.val);
            if(temp.right!=null) {((LinkedList<Node>) stack).push(temp.right);}
            if (temp.left!=null){((LinkedList<Node>) stack).push(temp.left);}
        }

        return 0;
    }
    public int add(Node node){
        List<Node> que=new LinkedList<>();
        Node point=root;
        ((LinkedList<Node>) que).offer(point);
        while(!que.isEmpty()){
            Node temp=((LinkedList<Node>) que).poll();
            if(temp.left!=null){
                ((LinkedList<Node>) que).offer(temp.left);
            }else {
                temp.left=node;
                return 0;
            }
            if (temp.right!=null){
                ((LinkedList<Node>) que).offer(temp.right);
            }else {
                temp.right=node;
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
         Node root=new Node(0);
        Main tree=new Main(root);
        root.left=new Node(1);
         root.right=new Node(2);
         tree.preOrder2();
        System.out.println("------------");
        tree.add(new Node(4));
         root.preOrder2(root);
        System.out.println("Hello World!");
    }
}
