import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Kenan on 3/12/2018.
 */
public class HuffmanDecode {
    HuffmanTree tree;
    HuffmanInputStream stream;
    BufferedWriter writer;
    int charactersRead = 0;


    public HuffmanDecode(String in, String out) throws IOException {
        //Implements the huffman decoding algorithm
        //Add private methods as needed
        stream = new HuffmanInputStream(in);
        tree = new HuffmanTree(stream.getTree(), (char)128);

        int totalChars = stream.getTotalChars();
        writer = new BufferedWriter(new FileWriter(out));

        while(charactersRead < totalChars){
            int bit = stream.readBit();
            //System.out.println("Designated bit: " + bit);

            if(bit == 0){
                //System.out.println("moved left");
                tree.moveToLeft();
            }
            else if(bit == 1){
                //System.out.println("moved right");
                tree.moveToRight();
            }

            if(tree.atLeaf()){
                //System.out.println("At leaf with data: " + tree.current());
                writer.write(tree.current());
                tree.moveToRoot();
            }
            charactersRead++;
        }
        writer.close();
    }

    public static void main(String args[]) throws IOException {
        new HuffmanDecode(args[0], args[1]);
    }
}
