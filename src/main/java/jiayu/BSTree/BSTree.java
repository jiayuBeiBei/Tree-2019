package jiayu.BSTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BSTree implements BSTreeAble<Integer,String>{
    private Entry ROOT;
    @Override
    public int put(Integer id, String val) {
        Entry temp=new Entry(id,val);
        if (ROOT==null){
            ROOT= temp;
            return OK;
        }
        return insertNode(temp,ROOT);
        
    }

    protected int insertNode(Entry node,Entry croot){
        if(node.getId()<croot.getId()) {
            if (croot.getLeft() == null) {
                croot.setLeft(node);
                node.setPar(croot);
                return OK;
            }
            return insertNode(node,croot.getLeft());
        }
        if (node.getId() > croot.getId()) {
            if (croot.getRight() == null) {
                croot.setRight(node);
                node.setPar(croot);
                return OK;
            }
            insertNode(node,croot.getRight());
        }
        if (node.getId()==croot.getId())
        {
            return ERROR;
        }
        return ERROR;
    }

    @Override
    public int remove(Integer id) {
        Entry croot=null;
        List<Entry> result=preOrder(ROOT);
        for (Entry i:result) {
            if (i.getId() == id) {
                 croot=i;
                 break;
            }
        }
        if (croot != null) {
            Entry min=midOrder(croot.getRight()).get(0);
            if (min.getPar().getLeft() == min) {
                min.getPar().setLeft(null);
            }else {
                min.getPar().setRight(null);
            }
            min.setPar(croot.getPar());
            min.setRight(croot.getRight());
            return OK;
        }
        return ERROR;
    }

    @Override
    public String find(Integer id) {
        //这个思路有问题,应该发挥二叉搜索树的特点
        List<Entry> result=preOrder(ROOT);
        for (Entry i:result) {
            if (i.getId() == id) {
                return i.getVal();
            }
        }
        return null;
    }

    @Override
    public List<Entry> preOrder(Entry croot) {
        List<Entry> result=new ArrayList<Entry>();
        List<Entry> stack=new LinkedList<Entry>();
        ((LinkedList<Entry>) stack).push(croot);
        while (!stack.isEmpty()) {
            Entry temp=((LinkedList<Entry>) stack).pop();
            //----------------
            System.out.println(temp.getId());
            result.add(temp);
            //---------------
            if (temp.getRight() != null) {
                ((LinkedList<Entry>) stack).push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                ((LinkedList<Entry>) stack).push(temp.getLeft());
            }
        }
        return result;
    }
    @Override
    public List<Entry> midOrder(Entry croot) {
        List<Entry> result=new ArrayList<Entry>();
        Entry point=croot;
        List<Entry> stack=new LinkedList<Entry>();
        while (point != null) {
            ((LinkedList<Entry>) stack).push(point);
            point=point.getLeft();
        }

        while(!stack.isEmpty()&&point==null){
            Entry temp=((LinkedList<Entry>) stack).pop();
            //-----------
            System.out.println(temp.getId());
            result.add(temp);
            //---------------------
            point=temp.getRight();
        }

        return result;
    }
    @Override
    public List<Entry> postOrder(Entry croot) {
        List<Entry> result=new ArrayList<Entry>();
        List<Entry> stack1=new LinkedList<Entry>();
        List<Entry> stack2=new LinkedList<Entry>();
        ((LinkedList<Entry>) stack1).push(croot);
        while (!stack1.isEmpty()) {
            Entry temp=((LinkedList<Entry>) stack1).pop();
            ((LinkedList<Entry>) stack2).push(temp);
            if (temp.getLeft() != null) {
                ((LinkedList<Entry>) stack1).push(temp.getLeft());
            }
            if (temp.getRight() != null) {
                ((LinkedList<Entry>) stack1).push(temp.getRight());
            }

        }

        for (Entry i:stack2) {
            System.out.println(i.getId());
            result.add(i);
        }
        return result;
    }
    @Override
    public Entry getROOT() {
        return ROOT;
    }

    public void setROOT(Entry ROOT) {
        this.ROOT = ROOT;
    }
}
