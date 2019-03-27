package jiayu.RBTree;


import java.util.LinkedList;
import java.util.List;

public class RBTree implements RBTreeAble{
    Entry ROOT=null;
    Entry temp=null;
    @Override
    public int put(int id, String val) {
        Entry node=new Entry(id,val);
        Entry grandson=addAs(node,ROOT );
        if (grandson.par==null||grandson.par.par==null){
            return OK;
        }else {
            int status=RBTreeRenewBalanceAt(grandson.par.par);//未完成
            return status;
        }

    }

    protected int AVLrenewBalanceAt(Entry croot) {
        //case ll
        //case  lr
        //case  rr
        //case  rl
        return OK;
    }

    protected int RBTreeRenewBalanceAt(Entry grandson) {
        /*
        * 祖孙三代赋值*/
        Entry father=null;
        Entry grandfather=null;
        Entry uncle=null;
        int  needFix=1;
        if (grandson.par!=null){
            father=grandson.par;

        }else {
            needFix=0;
        }
        if (father.par!=null)
        {
            grandfather=father.par;
        }else {
            needFix=0;
        }

        if (grandfather.left==father){
            uncle=grandfather.right;
        }else {
            uncle=grandfather.left;
        }
        if (needFix == 0) {
            return OK;
        }
        /*
         * ./ 祖孙三代赋值*/
        //case 1
        if (ROOT.color==RED) {
            ROOT.color=BLACK;
        }
        //case 2
        //case 3
        //case 4
        //case 5
        return OK;
    }
    @Override
    public int deleteBy(Entry croot) {
        return 0;
    }
    @Override
    public Entry isFoundBy(int id) {
        return null;
    }
    @Override
    public int fixAllTree(Entry ROOT) {
        //后序遍历整个树,从第一个输出的节点开始,平衡整个二叉树,每个节点都变黑
        List<Entry> postOrder=postOrder(ROOT);
        while(!postOrder.isEmpty()){
            Entry temp=postOrder.remove(postOrder.size()-1);
            AVLrenewBalanceAt(temp);
        }
        //调用AVLrenewBalanceAt()
        //把树拆了
        return 0;
    }

    protected  List<Entry> postOrder(Entry ROOT){
        List<Entry> stack1=new LinkedList();
        List<Entry> stack2=new LinkedList();
        stack1.add(ROOT);
        while (!stack1.isEmpty()) {
            Entry temp=((LinkedList<Entry>) stack1).remove();
            stack2.add(temp);
            if (temp.left!=null){
                stack1.add(temp.left);
            }
            if (temp.right!=null){
                stack1.add(temp.right);
            }
        }


        return stack2;
    }

    //没有就插入节点,有就返回原树内那个
    protected Entry addAs(Entry node,Entry croot){

       //case 1
        if (croot==null) {
            if (temp==null){
                //没有根节点, 当插入的是第一个节点  case 5
                ROOT=node;
                return node;
            }else {
                node.par=temp;
                if (temp.id<node.id){
                    temp.right=node;
                }else {
                    temp.left=node;
                }
            }

            return node;
        }
        //case 2
        if (node.id>croot.id){
            temp=croot;
            return addAs(node,croot.right);
        }
        //case 3
        if (node.id<croot.id){
            temp=croot;
            return addAs(node,croot.left);
        }
        //case4
        if(node.id==croot.id){
            return croot;
        }
        return node;
    }



}
