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
        bitsRead++;
        return bit;
    }

    private void fillBitArray() throws IOException {
        int b = d.readByte();
        if(b < 0){
            b *= -1;
        }
        System.out.println("Byte: " + b);
        System.out.println("Length: " + bits.length);
        for(int i = bits.length-1; i > 0; i--) {
            int bit = b % 2; //gets the bit
            bits[i] = bit;
            System.out.println("Bit: " + bits[i]);
            b = b / 2; //Moves to next bit
        }
    }

    public void close() throws IOException {
        d.close();
    }
}
