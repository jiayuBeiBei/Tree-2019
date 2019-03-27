package jiayu.AVL;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Avl implements AvlAble<Integer,String> {

    private Entry ROOT;

    /**   if (temp.getPar() != null && temp.getPar().getPar() != null) {
            grandson=temp.getPar().getPar();
        }else {
            return OK;
        }
        //ll 右旋
        if (grandson.getLeft().getLeft() == temp) {
            if (grandson.getRight() == null) {
                return OK;
            }
            return OK;
        }
        //lr 右旋
        if (grandson.getLeft().getRight() == temp) {
            if (grandson.getRight() == null) {
                return OK;
            }
            return OK;
        }
        //rl    左旋
        if (grandson.getRight().getLeft() == temp) {
            if (grandson.getLeft() == null) {
                return OK;
            }
            return OK;
        }
        //rr    左旋
        if (grandson.getRight().getRight() == temp) {
            if (grandson.getRight() == null) {
                return OK;
            }
            return  OK;
        }*/
    @Override
    public int put(Integer id, String val) {
        Entry temp=new Entry(id,val);
        Entry grandson=null;
        if (ROOT==null){
            ROOT= temp;
            return OK;
        }
        insertNode(temp,ROOT);
       List<Entry> result= postOrder(ROOT);
       for (Entry i:result){
           if (high(i.getLeft())-high(i.getRight())>1){
               //左子树高,且不平衡,所以,右旋
               rotateRight(i);

           }
           if (high(i.getRight()) - high(i.getLeft()) > 1) {
               //右子树高,且不平衡,所以,左旋
               rotateLeft(i);

           }
       }
        return OK;
    }

    protected int insertNode(Entry node, Entry croot){
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
            List<Entry> result2= postOrder(ROOT);
            for (Entry i:result2){
                if (high(i.getLeft())-high(i.getRight())>1){
                    //左子树高,且不平衡,所以,右旋
                    rotateRight(i);

                }
                if (high(i.getRight()) - high(i.getLeft()) > 1) {
                    //右子树高,且不平衡,所以,左旋
                    rotateLeft(i);

                }
            }

            return OK;
        }
        return ERROR;
    }

    @Override
    public String find(Integer id) {
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
    public int fix(Entry croot) {
        if (croot == null) {
            return ERROR;
        }
        List<Entry> result= postOrder(croot);
        for (Entry i:result){
            if (high(i.getLeft())-high(i.getRight())>1){
                //左子树高,且不平衡,所以,右旋
                rotateRight(i);

            }
            if (high(i.getRight()) - high(i.getLeft()) > 1) {
                //右子树高,且不平衡,所以,左旋
                rotateLeft(i);

            }
        }
        return 0;
    }

    @Override
    public int rotateRight(Entry croot) {
        Entry newCroot=croot.getLeft();
        Entry newRightCroot=croot;
        Entry newRightLeftCroot=croot.getLeft().getRight();
        newCroot.setPar(croot.getPar());
        newCroot.setRight(newRightCroot);
        newRightCroot.setLeft(newRightLeftCroot);
        newRightCroot.setPar(newCroot);
        newRightLeftCroot.setPar(newRightCroot);

        return 0;
    }

    @Override
    public int rotateLeft(Entry croot) {
        Entry newCroot=croot.getRight();
        Entry newLeftCroot=croot;
        Entry newLeftRightCroot=croot.getRight().getLeft();
        newCroot.setPar(croot.getPar());
        newCroot.setLeft(croot);
        newLeftCroot.setRight(newLeftRightCroot);
        newLeftCroot.setPar(newCroot);
        newLeftRightCroot.setPar(newLeftCroot);
        return 0;
    }

    protected int high(Entry croot){
        if (croot.getRight()==null&&croot.getLeft() == null) {
            return 1;
        }
        if (croot.getLeft() != null) {
            return high(croot.getLeft())+1;
        }
        if (croot.getRight() != null) {
            return high(croot.getRight())+1;
        }
        return 0;
    }
}
