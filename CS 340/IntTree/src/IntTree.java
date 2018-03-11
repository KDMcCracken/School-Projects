/**
 * Created by Kenan on 2/26/2018.
 */
import java.io.*;
import java.util.*;
public class IntTree {

    private class Node {
        private int data;
        private Node firstChild;
        private Node sibling;
        private Node parent;

        private Node (int d, Node f, Node s, Node p) {
            data = d;
            firstChild = f;
            sibling = s;
            parent = p;
        }
    }
    private Node root;

    public IntTree(int d) {
        //create a one node tree
        root = new Node(d,null,null,null);
    }

    public IntTree(int d, IntTree t[]) {
        //create a new tree whose children are the trees in t and whose root value is d
        this.root = new Node(d, null, null, null);
        for(int x = 0; x < t.length; x++){
            if(x == 0){
                this.root.firstChild = t[x].root;
                t[x].root.parent = this.root;
            }
            else{
                Node tmp = this.root.firstChild;
                while(tmp.sibling != null){
                    tmp = tmp.sibling;
                }
                tmp.sibling = t[x].root;
                t[x].root.parent = this.root;
            }
        }
    }

    public IntTree(int d[]) {
        //create a tree with d[0] as the root value and the other values as children of the root
        for(int x = 0; x < d.length; x++){
            if(x == 0) {
                this.root = new Node(d[x], null, null, null);
                continue;
            }
            if(this.root.firstChild == null){
                this.root.firstChild = new Node(d[x],null,null,this.root);
            }else{
                Node tmp = this.root.firstChild;
                while (tmp.sibling != null) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = new Node(d[x], null, null, this.root);
            }
        }
    }

    public IntTree(int d, IntTree c) {
        root = new Node(d,c.root,null,null);
        c.root.parent = root;
    }


    public String preorder() {
        //return a string of the ints in the tree in preorder
        //separate the ints with commas
        //the implementation must be recursive
        String preOrder = preOrderhelper(this.root);
        if(preOrder.endsWith(",")){
            preOrder = preOrder.substring(0,preOrder.length()-1);
        }
        return preOrder;
    }
    private String preOrderhelper(Node r){
        String returnThis = Integer.toString(r.data) + ",";
        if(r.firstChild != null){
            returnThis += preOrderhelper(r.firstChild);
        }
        if(r.sibling != null){
            returnThis += preOrderhelper(r.sibling);
        }
        return returnThis;
    }

    public String postorder() {
        //return a string of the ints in the tree in postorder
        //separate the ints with commas
        //the implementation must be recursive
        String postOrder = postOrderhelper(this.root);
        return postOrder.substring(0,postOrder.length()-1);
    }
    private String postOrderhelper(Node r){
        String post = "";
        if(r == null){
            return post;
        }
        if(r.firstChild != null) {
            post += postOrderhelper(r.firstChild);
        }
        if(r.sibling != null) {
            return post + r.data + "," + postOrderhelper(r.sibling);
        }
        return post + r.data + ",";
    }

    public String levelorder() {
        //return a string of the ints in the tree in level order (also know a breadth first order)
        //separate the ints with commas
        //the implementation must be iterative
        StringBuilder levelOrder = new StringBuilder();
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(this.root);
        while(queue.size() > 0) {
            Node currentNode = queue.pop();
            levelOrder.append(currentNode.data + ",");
            if (currentNode.sibling != null) {
                queue.addFirst(currentNode.sibling);
            }
            if (currentNode.firstChild != null) {
                queue.addLast(currentNode.firstChild);
            }
        }
        levelOrder.deleteCharAt(levelOrder.length()-1);
        return levelOrder.toString();
    }

    public String path(int d) {
        //return the ints in the path from the first occurrence of d in the tree to the root of the tree
        //the “first occurrence” means the first occurrence found in a preorder traversal
        //the implementation must use the parent reference to create the path
        //separate the ints with commas
        //the implementation must be iterative
        if(this.root.data == d){return Integer.toString(this.root.data);}
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(this.root);
        while(queue.size() > 0) {
            Node currentNode = queue.pop();
            if (currentNode.data == d) {
                return findPath(currentNode);
            }
            if (currentNode.firstChild != null) {
                queue.addFirst(currentNode.firstChild);
            }
            if (currentNode.sibling != null) {
                queue.addLast(currentNode.sibling);
            }
        }
        return null;
    }
    private String findPath(Node r) {
        String path = "";
        ArrayList<Integer> siblingPath = new ArrayList<>();
        Node reference = r.parent; //Reference used to loop through children
        Node lastParent = r; //Used as a stopping point for loop
        while (reference != null) {
            Node currentNode = reference.firstChild;
            while (!currentNode.equals(lastParent)) {
                siblingPath.add(currentNode.data);
                currentNode = currentNode.sibling;
            }
            //Adds the @param Nodes data if it is the first time through
            if(currentNode.equals(r)){
                siblingPath.add(r.data);
            }
            Collections.reverse(siblingPath); //Reverses the created siblingPath and adds to @return path
            for (int num : siblingPath) {
                path += num + ",";
            }
            siblingPath.clear();
            path += reference.data + ",";

            lastParent = reference;
            reference = reference.parent;
        }
        //Removes extra comma from final path
        if (path.length() > 0) {
            path = path.substring(0, path.length() - 1);
        }
        return path;
    }

    public int count(int d) {
        //return the number of times d appears in the tree
        //the implementation must be recursive
        return count(d,this.root);
    }
    private int count(int d, Node r){
        int total = 0;
        if(r.data == d){total++;}
        if(r.firstChild == null && r.sibling == null){
            return total;
        }
        if(r.sibling == null){
            return total += count(d,r.firstChild);
        }
        if(r.firstChild == null){
            return total += count(d,r.sibling);
        }
        return total += count(d,r.sibling) + count(d,r.firstChild);
    }

    public int sum() {
        //return the sum of the ints in the tree
        //the implementation must be iterative
        int sum = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(this.root);
        while(queue.size() > 0) {
            Node currentNode = queue.pop();
            sum += currentNode.data;
            if (currentNode.sibling != null) {
                queue.addFirst(currentNode.sibling);
            }
            if (currentNode.firstChild != null) {
                queue.addLast(currentNode.firstChild);
            }
        }
        return sum;
    }
}
