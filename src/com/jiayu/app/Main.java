package com.jiayu.app;

import java.util.LinkedList;
import java.util.List;

public class Main {

    Node root=null;
    //第二种方法
    private int preOrder2(Node root){
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
    public int add(int val){
        if(root==null){
            root=new Node(val);
        }else{
            //层序查找完全二叉树,返回要加的子节点位置的指针
            Node last=findBTreeLastNode(root);
            last=new Node(val);
        }
        return 0;
    }
    public int remove(){
//      层序查找完全二叉树,返回要删除的子节点位置的指针
        Node last=removeBTreeLastNode(root);
        if (last.right!=null){
            last.right=null;
        }else {
            last.left=null;
        }
        return 0;
    }
    private Node removeBTreeLastNode(Node root){
        //层序查找完全二叉树要加的子节点的位置
        List<Node> queue=new LinkedList();
        queue.add(root);
        Node temp=null;
        while(!queue.isEmpty()){
            temp=queue.remove(0);
            if (temp==null){return null;}//根本没结点
            if (temp.left!=null){
                queue.add(temp.left);
            }else{
                return temp;
            }
            if (temp.right!=null){
                queue.add(temp.right);
            }else {
                return temp;
            }
        }
        return null;//未知错
    }
    private Node findBTreeLastNode(Node root){
        //层序查找完全二叉树要加的子节点的位置
        List<Node> queue=new LinkedList();
        queue.add(root);
        Node temp=null;
        while(!queue.isEmpty()){
            temp=queue.remove(0);
            if (temp==null){return null;}//根本没结点
            if (temp.left!=null){
                queue.add(temp.left);
            }else{
                return temp.left;
            }
            if (temp.right!=null){
                queue.add(temp.right);
            }else {
                return temp.right;
            }
        }
        return null;//未知错
    }
    public static void main(String[] args) {
        Main tree=new Main();
            tree.add(0);
            tree.add(1);
            tree.add(2);
            tree.add(3);
            tree.remove();
        System.out.println("Hello World!");
    }
}
