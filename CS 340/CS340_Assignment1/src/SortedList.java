/**
 * Created by Kenan McCracken on 1/26/2018.
 */
import java.io.*;
import java.util.*;
public class SortedList<T extends Comparable<? super T>> {
    private Node head; //Reference to the first node in the list
    private int size; //The number of elements in the list

    //Implements a generic singly linked list of Comparable objects
    //Sorted in ascending order
    public SortedList() {
    //Constructor for an empty list
        head = null; //no sentinel node
        size = 0;
    }

    public SortedList(SortedList<T> s1, SortedList<T> s2) {
        //PRE: s1.size() > 0 && s2.size() > 0
        //Constructor for the list created from two SortedLists
        //A new SortedList is created containing all the data from s1 and s2
        //The implementation must take advantage of the fact that s1 and s2
        //are sorted. The implementation cannot use the insert method

        /*
            Both following temp nodes are used to track the current nodes being compared
         */
        Node s1Temp = s1.head;
        Node s2Temp = s2.head;
        /*
            First check to see if a head is referencing anything.
            We know that the first time through it will not be so
            this sets it up
         */
        if(this.head == null){
            if(s1.head.data.compareTo(s2.head.data) < 0){
                this.head = new Node(s1.head.data, null);
                s1Temp = s1Temp.next;
            }
            else{
                this.head = new Node(s2.head.data, null);
                s2Temp = s2Temp.next;
            }
            size++;
        }
        Node current = this.head; // Node to keep track of place

        /*
            Compares all other nodes and keeps them in a sorted order
         */
        while(s1Temp != null || s2Temp != null){
            if(s1Temp != null && s2Temp != null){
                if (s1Temp.data.compareTo(s2Temp.data) < 0) {
                        current.next = new Node(s1Temp.data, null);
                        s1Temp = s1Temp.next;
                } else {
                        current.next = new Node(s2Temp.data, null);
                        s2Temp = s2Temp.next;
                }
            }
            else if(s1Temp == null){
                current.next = new Node(s2Temp.data,null);
                s2Temp = s2Temp.next;
            }
            else if(s2Temp == null){
                current.next = new Node(s1Temp.data,null);
                s1Temp = s1Temp.next;
            }
            current = current.next;
            size++;
        }
    }
    private class Node {
        private T data;
        private Node next;
        private Node(T d, Node n) {
            data = d;
            next = n;
        }
    }

    public void insert(T item) {
        //Insert item into the list so the list remains sorted
        //The list can contain duplicates
        if(head == null){
            head = new Node(item, null);
        }
        else if(this.head.next != null) {
            Node temp = this.head;
            boolean added = false; //Used to confirm whether the item was added to the list
            while (temp.next != null) {
                if (temp.next.data.compareTo(item) >= 0) {
                    temp.next = new Node(item, temp.next);
                    added = true;
                    break;
                }
                temp = temp.next;
            }
            if(!added){
                temp.next = new Node(item,null);
            }
        }
        else{
            this.head.next = new Node(item, null);
        }
        this.size++;
    }

    public void remove(T item) {
        //Remove all occurrences of item from the list
        //Node ref = new Node(null,this.head);
        Node current = this.head; //Place tracker
        if(this.head.data.compareTo(item) == 0){
            while(this.head.data.compareTo(item) == 0){
                this.head = this.head.next;
            }
        }

        while(current.next != null){
            if(current.next.data.compareTo(item) == 0){
                while(current.next.data.compareTo(item) == 0) {
                    if(current.next.next == null){
                        current.next = null;
                        return;
                    }
                    else {
                        current.next = current.next.next;
                    }
                    this.size--;
                }
            }
            current = current.next;
        }
    }

    public int find(T item) {
        //Return the number of times item is found on the list
        //Use equals or compareTo not == to compare items
        int count = 0; //Total Nodes with @param 'item' found
        Node temp = this.head; //Place tracker
        while(temp != null){
            if(temp.data.compareTo(item) == 0) {
                count++;
                while (temp.next != null && temp.next.data.compareTo(item) == 0) {
                    count++;
                    temp = temp.next;
                }
                return count;
            }
            temp = temp.next;
        }

        return 0;
    }

    public int size() {
        //Return the number of items in the list
        return size;
    }
    public String toString() {
        //Return a string representation of the list
        //The string representation of the list is a [ followed by the items in the list
        //separated by commas followed by a ]
        //For example a list of integers could look like [2,3,7,10,50,107]
        String listString = "["; //String to return
        Node currentNode = this.head; //Place tracker
        while(currentNode != null){
            if(currentNode.next == null){
                listString += currentNode.data;
            }
            else {
                listString += currentNode.data + ",";
            }
            currentNode = currentNode.next;
        }
        listString += "]";
        return listString;
    }
}
