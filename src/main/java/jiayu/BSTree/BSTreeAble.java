package jiayu.BSTree;

import java.util.List;

public interface BSTreeAble<K,V>{


    static class Entry{
        private Entry par;
        private Entry left;
        private Entry right;
        private int id ;
        private String val;

        public Entry(int id, String val) {
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

        public Entry getPar() {
            return par;
        }

        public void setPar(Entry par) {
            this.par = par;
        }

        public Entry getLeft() {
            return left;
        }

        public void setLeft(Entry left) {
            this.left = left;
        }

        public Entry getRight() {
            return right;
        }

        public void setRight(Entry right) {
            this.right = right;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }
    int ERROR=0;
    int OK=1;
    int put(K id,V val);

    int remove(K id);

    String find(K id);

    List preOrder(Entry croot);

    List midOrder(Entry croot);

    List postOrder(Entry croot);

    Entry getROOT();

}
