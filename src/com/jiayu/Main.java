package com.jiayu;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

    Node root=null;


    private int preOrder(Node root){
        List<Node> stack=new LinkedList<>();
        Node p=root;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                System.out.println(p.val);
                stack.add(p);
                //System.out.println(p.val);
                p=p.left;
            }
            if (!stack.isEmpty()){
                    Node temp=stack.remove(stack.size()-1);
                    p=temp.right;

            }

        }
        return 0;
    }
    private int inOrder(Node root){
        List<Node> stack=new LinkedList<>();
        Node p=root;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){

                stack.add(p);

                p=p.left;
            }
            if (!stack.isEmpty()){
                Node temp=stack.remove(stack.size()-1);
                if(temp!=null){System.out.println(temp.val);}
                p=temp.right;

            }

        }
        return 0;
    }
    //后序遍历的非递归实现
    public void noRecPostOrder(Node root){
        Stack<Node> stack=new Stack<Node>();
        Node node =root;
        while(root!=null){
            //左子树入栈
            for(;root.left!=null;root=root.left){
                stack.push(root);
            }
            //当前结点无右子树或右子树已经输出
            while(root!=null&&(root.right==null||root.right==node)){
                //第一种情况 ;当前root节点,左右节点都为null
                //第二种情况: 当前root节点,右节点为根节点
                System.out.println(root.val);
                //纪录上一个已输出结点
                node =root;
                if(stack.empty()){
                    return;}
                root=stack.pop();
            }
            //处理右子树
            stack.push(root);
            root=root.right;
        }
    }

    public static void main(String[] args) {
        Main tree=new Main();
       Node root=new Node(1);
       Node croot2=new Node(2);
       Node croot3=new Node(3);
       Node croot4=new Node(4);
       root.setLeft(croot2);
       root.setRight(croot3);
       croot3.setLeft(croot4);
        tree.preOrder(root);
        System.out.println("---------mid");
        tree.inOrder(root);
        System.out.println("---------post");
        tree.noRecPostOrder(root);

    }
}
