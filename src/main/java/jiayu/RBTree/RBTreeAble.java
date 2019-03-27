package jiayu.RBTree;



public interface RBTreeAble {
    //Entry ROOT=null; 这里定义的变量是final类型的,无法修改
    int OK=1;
    int ERROR=0;
    int RED=0;
    int BLACK=1;
    static class Entry{
        Entry par;
        Entry left;
        Entry right;
        int id ;
        String val;
        int color=RED;
        public Entry(int id, String val) {
            this.id = id;
            this.val = val;
        }

        public Entry(Entry par, int id, String val) {
            this.par = par;
            this.id = id;
            this.val = val;
        }

        public Entry(Entry par, Entry left, Entry right, int id, String val) {
            this.par = par;
            this.left = left;
            this.right = right;
            this.id = id;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    " left=" + left +
                    ", right=" + right +
                    ", id=" + id +
                    ", val='" + val + '\'' +
                    '}';
        }
    }
    int put(int id,String val);

    int  deleteBy(Entry croot);
    Entry  isFoundBy(int id);
    int fixAllTree(Entry ROOT);


}
