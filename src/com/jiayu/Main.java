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
    public int add(Node croot,int val){
        if (croot==null){
            croot = new Node(val);
            return 0;
        }else {

            if (croot.val>val){
                add(croot.left,val);
            }else{
                add(croot.right,val);
            }
        }
        return 0;
    }
    public int remove(Node croot,int val){
        if (croot==null){

            return 1;
        }else {
            if (croot.val==val) {
                //删除之后的改动
                //层序,找到左子树最大值
                //返回改造好的根节点,把此处croot的右节点加入进来,把返回改造好的根节点挂在父节点下

            }else if (croot.val>val){
                remove(croot.left,val);
            }else{
                remove(croot.right,val);
            }
        }
        return 0; 
    }
    private Node levelOrderRemoveLeftTreeMaxVal(Node croot){
        List<Node> que=new LinkedList<Node>();
        que.add(croot);
        Node temp=null;

        Node maxNode=croot;
        while(que.size()!=0){
            temp=que.remove(0);
            if (temp!=null){
                if (temp.val>maxNode.val){
                    maxNode=temp;
                }
            }
            if (temp.left!=null){
                que.add(temp.left);
            }
            if (temp.right!=null){
                que.add(temp.right);
            }

        }

        if (maxNode.left==null&&maxNode.right==null){
            return maxNode;
        }

        return maxNode;
    }
    public static void main(String[] args) {
        Main tree=new Main();
//            tree.add(0);
//            tree.add(1);
//            tree.add(2);
//            tree.add(3);
//            tree.remove();
        System.out.println("Hello World!");
    }
}
