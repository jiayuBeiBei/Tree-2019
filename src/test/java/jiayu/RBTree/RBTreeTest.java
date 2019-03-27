package jiayu.RBTree;


import org.junit.Test;

public class RBTreeTest {

    RBTree rbTreeAble=new RBTree();
    RBTreeAble.Entry root=null;

    public void before() {
        root = new RBTreeAble.Entry(5,"five");
        RBTreeAble.Entry left=new RBTreeAble.Entry(1,"one");
        left.par=root;
        root.left=left;
//        rbTreeAble.ROOT=root;

    }

    @Test
    public void put() {
        System.out.println(rbTreeAble.put(10,"ten"));
        System.out.println(rbTreeAble.put(1,"one"));
        System.out.println(rbTreeAble.put(5,"five"));
        System.out.println("root:"+rbTreeAble.ROOT.toString());
    }

    @Test
    public  void add(){
        root = new RBTreeAble.Entry(5,"five");
        RBTreeAble.Entry left=new RBTreeAble.Entry(1,"one");
        left.par=root;
        root.left=left;
        RBTreeAble.Entry right=new RBTreeAble.Entry(10,"ten");
        RBTreeAble.Entry node=rbTreeAble.addAs(right,root);
        System.out.println("node:"+node.toString());
        System.out.println("root:"+root.toString());
        System.out.println("node.par:"+node.par);

    }
    @Test
    public  void add2(){
        root = new RBTreeAble.Entry(5,"five");
        RBTreeAble.Entry left=new RBTreeAble.Entry(1,"one");
        left.par=root;
        root.left=left;
        rbTreeAble.ROOT=root;
        RBTreeAble.Entry right=new RBTreeAble.Entry(1,"ten");
        RBTreeAble.Entry node=rbTreeAble.addAs(right,root);
        System.out.println("node:"+node.toString());
        System.out.println("root:"+root.toString());
        System.out.println("node.par:"+node.par);
        System.out.println("ROOT:"+rbTreeAble.ROOT.toString());

    }
}
