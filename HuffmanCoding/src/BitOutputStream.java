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
    private int b = 0;

    public BitOutputStream(String filename) {
        try {
            d = new DataOutputStream(new FileOutputStream(filename));
        }
        catch (IOException e) {
        }
    }
    public void writeBit(char bit) throws IOException {
        //PRE: bit is a '0' or a '1'
        int intbit = Integer.parseInt(bit + "");
        b = b * 2 + intbit;
        bitCount++;
        if(bitCount == ByteSize){
            d.write(b);
            bitCount = 0;
            b = 0;
        }

    }
    public void close() throws IOException {
        for (int i = bitCount; i <= 8; i++) {
            writeBit('0');
        }

        d.close();
    }
}
