import java.util.*;

/**
 * Created by Kenan on 3/12/2018.
 */
public class HuffmanTree {
    //add additional private variables as needed
    //do not modify the public method signatures or add public methods
    private class Node {
        private Node left;
        private char data;
        private Node right;
        private Node parent;

        private Node(Node L, char d, Node R, Node P) {
            left = L;
            data = d;
            right = R;
            parent = P;
        }
    }

    private Node root;
    private Node current; //this value is changed by the move methods
    private char nonLeaf;

    public HuffmanTree() {
        root = null;
        current = null;
    }

    public HuffmanTree(char d) {
        //makes a single node tree
        root = new Node(null,d,null,null);
    }

    public HuffmanTree(String t, char nonLeaf) {
        //Assumes t represents a post order representation of the tree as discussed
        //in class
        //nonLeaf is the char value of the data in the non-leaf nodes
        //in class we used (char) 128 for the non-leaf value
        Stack<HuffmanTree> stack = new Stack<>();
        char[] postOrder = t.toCharArray();

        for(char character : postOrder){
                if(character == nonLeaf){
                    stack.push(new HuffmanTree(stack.pop(),stack.pop(),nonLeaf));
                }
                else{
                    stack.push(new HuffmanTree(character));
                }
        }
        this.nonLeaf = nonLeaf;
        this.root = stack.pop().root;
        current = this.root;

    }

    public HuffmanTree(HuffmanTree b1, HuffmanTree b2, char d) {
        //makes a new tree where b1 is the left subtree and b2 is the right subtree
        //d is the data in the root
        this.root = new Node(b1.root,d,b2.root,null);
        this.current = this.root;
        b1.root.parent = this.root;
        b2.root.parent = this.root;
    }

    //use the move methods to traverse the tree
    //the move methods change the value of current
    public void moveToRoot() {
        this.current = this.root;
    }

    public void moveToLeft() {
        this.current = this.current.left;
    }

    public void moveToRight() {
        this.current = this.current.right;
    }

    public void moveToParent() {
        this.current = this.current.parent;
    }

    public boolean atLeaf() {
        //returns true if current references a leaf other wise returns false
        if(current.data != nonLeaf) {
            return true;
        }
        return false;
    }

    public char current() {
        //returns the data value in the node referenced by current
        return this.current.data;
    }


    public Iterator<String> iterator() {
        //return a PathIterator object
        return new PathIterator();
    }

    public String toString() {
        //return a post order representation of the tree
        //using the format we discussed in class]
        return toString(root);
    }

    private String toString(Node r){
        if(r == null){
            return "";
        }
        return toString(r.left) + toString(r.right) + r.data;
    }

    //the iterator returns the path (a series of 0s and 1s) to each leaf

    public class PathIterator implements Iterator<String> {

        LinkedList<String> list;

        public PathIterator(){
            list = new LinkedList<>();
            fillList(root, "");
        }

        public boolean hasNext() {
            return(!list.isEmpty());
        }

        public String next() {
            return list.remove();
        }

        public void remove() {
            //optional method not implemented
        }

        private void fillList(Node r, String path){
            if(r.left == null){
                list.add(r.data + path);
            }
            else{
                fillList(r.left, path + '0');
                fillList(r.right, path + '1');
            }
        }

    }
}
