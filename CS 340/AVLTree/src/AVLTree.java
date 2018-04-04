/**
 * Created by KDMcC on 3/29/2018.
 */
import java.io.*;
import java.util.*;

public class AVLTree {
    /*
    Implements an ALV tree of ints stored in a random access file.
    Duplicates are recorded by a count field associated with the int
    */
    final int CREATE = 0;
    final int REUSE = 1;
    private RandomAccessFile f;
    long root; //the address of the root node in the file
    long free; //the address in the file of the first node in the free list

    private class Node {
        private long left;
        private int data;
        private int count;
        private long right;
        private int height;
        private Node(long L, int d, long r) {
            //constructor for a new node
            left = L;
            data = d;
            right = r;
            count = 1;
            height = 0;
        }
        private Node(long addr) throws IOException{
            //constructor for a node that exists and is stored in the file
            f.seek(addr);
            data = f.readInt();
            count = f.readInt();
            height = f.readInt();
            left = f.readLong();
            right = f.readLong();
        }
        private void writeNode(long addr) throws IOException {
            //writes the node to the file at location addr
            f.seek(addr);
            f.writeInt(this.data);
            f.writeInt(count);
            f.writeInt(height);
            f.writeLong(left);
            f.writeLong(right);
        }
    }

    public AVLTree(String fname, int mode) throws IOException {
        //if mode is CREATE a new empty file is created
        //if mode is CREATE and a file with file name fname exists the file with
        //fname must be deleted before the new empty file is created
        //if mode is REUSE an existing file is used if it exists otherwise a new empty
        //file is created
        if(mode == CREATE){
            f = new RandomAccessFile(fname,);
        }
        //TODO:
    }

    public void insert(int d) throws IOException {
        //insert d into the tree
        //if d is in the tree increment the count field associated with d
        //TODO: Write rotate methods
    }

    private long insert(long r, int d) throws IOException{
        Node temp;
        if(r == 0){
            temp = new Node(0,d,0);
            long addr = f.1
        }
        temp = new Node(r);
        if(d < temp.data){
            temp.left = insert(temp.left,d);
        }
        else if(d > temp.data){
            temp.right = insert(temp.right,d);
        }
        else{
            temp.count++;
            temp.writeNode(r);
            return r;
        }

        //TODO: Fix first IF statement
    }

    public int find(int d) throws IOException {
        //if d is in the tree return the value of count associated with d
        //otherwise return 0
        f.seek(0);
        return findHelper(f.readLong(),d);
    }
    private int findHelper(Long r, int d) throws IOException{
        Node temp = new Node(r);
        if(temp.data == d){
            return temp.count;
        }
        else if(temp.data < d){
            findHelper(temp.left,d);
        }
        else{
            findHelper(temp.right,d);
        }
        return 0;
    }


    public void removeOne(int d) throws IOException {
        //remove one copy of d from the tree
        //if the copy is the last copy remove d from the tree
        //if d is not in the tree the method has no effect
        f.seek(0);
        if(find(d) > 0){
            Long address = findAddress(f.readLong(),d);
            Node nodeToChange = new Node(address);
            if(nodeToChange.count > 1){
                nodeToChange.count--;
                nodeToChange.writeNode(address);
            }
            else {
                //TODO: Remove node from tree
            }
        }
    }

    public void removeAll(int d) throws IOException {
        //remove d from the tree
        //if d is not in the tree the method has no effect
    }

    public void close() {
        //close the random access file
        //before closing update the values of root and free if necessary
    }

    private int getHeight(){

    }

    private Long findAddress(Long r, int d)throws IOException{
        Node temp = new Node(r);
        if(temp.data == d){
            return r;
        }
        else if(temp.data < d){
            findAddress(temp.left,d);
        }
        else{
            findAddress(temp.right,d);
        }
    }
}
