import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Kenan on 3/12/2018.
 */
public class BitInputStream {
    //add additional protected variables as needed
    //do not modify the public methods signatures or add public methods
    int[] bits = new int[8];
    int bitsRead = 8;
    protected DataInputStream d;
    public BitInputStream(String filename) {
        try {
            d = new DataInputStream(new FileInputStream(filename));
        }
        catch (IOException e) {
        }
    }
    public int readBit() throws IOException {
        //return the next bit in the file
        if (bitsRead == 8) {
            fillBitArray();
            bitsRead = 0;
        }
        int bit = bits[bitsRead];
        System.out.print(bit);
        bitsRead++;
        return bit;
    }

    private void fillBitArray() throws IOException {
        System.out.println();
        System.out.print("bitArray: ");
        int b = d.readUnsignedByte();
        for(int i = bits.length-1; i >= 0; i--){
            int bit = b % 2; //gets the bit
            bits[i] = bit;
            b = b / 2; //Moves to next bit
        }

        for (int i = 0; i < bits.length; i++){
            System.out.print(bits[i]);
        }
        System.out.println("\n");
    }

    public void close() throws IOException {
        d.close();
    }
}
