import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Kenan on 3/12/2018.
 */
public class BitOutputStream {
    //add additional protected variables as needed
    //do not modify the public methods signatures or add public methods
    protected DataOutputStream d;
    private int ByteSize = 8;
    private int bitCount = 0;
    private char[] bits = new char[8];

    public BitOutputStream(String filename) {
        try {
            d = new DataOutputStream(new FileOutputStream(filename));
        }
        catch (IOException e) {
        }
    }
    public void writeBit(char bit) throws IOException {
        //PRE: bit is a '0' or a '1'
        if(bitCount == ByteSize){
            bitCount = 0;
            char b = (char)Integer.parseInt(new String(bits), 2);
            d.write(b);
        }
        else {
            bits[bitCount] = bit;
            bitCount++;
        }
    }
    public void close() throws IOException {
        Arrays.fill(bits,bitCount,ByteSize,'0');
        char b = (char)Integer.parseInt(new String(bits), 2);
        d.write(b);
        d.close();
    }
}
