import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

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

    public HuffmanTree() {
        root = null;
        current = null;
    }

    public HuffmanTree(char d) {
        //makes a single node tree
        this.root = new Node(null,d,null,null);
        this.current = this.root;
    }

    public HuffmanTree(String t, char nonLeaf) {
        //Assumes t represents a post order representation of the tree as discussed
        //in class
        //nonLeaf is the char value of the data in the non-leaf nodes
        //in class we used (char) 128 for the non-leaf value
        Stack<HuffmanTree> stack = new Stack<>();
        char[] postOrder = t.toCharArray();

        for(char character : postOrder){
                if(character != nonLeaf){
                    stack.push(new HuffmanTree(character));
                }
                else{
                    HuffmanTree current = new HuffmanTree();
                    current.root = new Node(stack.pop().root,nonLeaf,stack.pop().root,null);
                    stack.push(current);
                }
        }
    }

    public HuffmanTree(HuffmanTree b1, HuffmanTree b2, char d) {
        //makes a new tree where b1 is the left subtree and b2 is the right subtree
        //d is the data in the root
        this.root = new Node(b1.root,d,b2.root,null);
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
        //returns true if current references a leave other wise returns false
        if(this.current.left == null && this.current.right == null) {
            return true;
        }
        return false;
    }

    public char current() {
        //returns the data value in the node referenced by current
        return this.current.data;
    }

    //the iterator returns the path (a series of 0s and 1s) to each leaf
    public class PathIterator implements Iterator<String> {

        public PathIterator() {

        }

        public boolean hasNext() {
            return atLeaf();
        }

        public String next() {
            return "";
        }

        public void remove() {
            //optional method not implemented
        }

        public Iterator<String> iterator() {
            //return a PathIterator object
        }

        public String toString() {
            //return a post order representation of the tree
            //using the format we discussed in class
            return "";
        }
    }
}
