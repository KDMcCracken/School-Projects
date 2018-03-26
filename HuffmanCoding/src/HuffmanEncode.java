/**
 * Created by Kenan on 3/12/2018.
 */
import java.io.*;
import java.util.*;

public class HuffmanEncode {
    int[] frequency = new int[128];
    PriorityQueue<Item> queue = new PriorityQueue<>(128);
    char rootCharacter = (char) 128;

    public HuffmanEncode(String in, String out) throws IOException{
        //Implements the huffman encoding algorithm
        //Add private methods as needed
        BufferedReader reader = new BufferedReader(new FileReader(in));
        int ASCII = reader.read(); // An int equal to the letters character code
        // ASCII would equal -1 if the reader had nothing left to read
        while(ASCII != -1){
            frequency[ASCII]++;
            ASCII = reader.read();
        }
        reader.close();

        //Adds all chars with a frequency greater than 0 to the queue
        for (int i = 0; i < frequency.length; i++){
            if(frequency[i] > 0) {
                queue.add(new Item(frequency[i], new HuffmanTree((char) i)));
            }
        }

        buildHuffmanTree();
        HuffmanTree tree = queue.poll().tree;

    }

    public static void main(String args[]) throws IOException{
        new HuffmanEncode(args[0], args[1]);
    }

    private void buildHuffmanTree(){
        while(queue.size() > 1){
            Item left = queue.poll();
            Item right = queue.poll();
            int newFrequency = left.freq+right.freq;
            Item newNode = new Item(newFrequency, new HuffmanTree(left.tree,right.tree,rootCharacter));
            queue.add(newNode);
        }
    }


    private	class Item implements Comparable {
        private int freq;
        private HuffmanTree tree;

        private Item(int f, HuffmanTree tree) {
            freq = f;
            this.tree = tree;
        }

        public int compareTo(Object x) {
            return freq - ((Item) x).freq;
        }
    }

}
