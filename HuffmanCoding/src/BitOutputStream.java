import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Kenan on 3/12/2018.
 */
public class BitOutputStream {
    //add additional protected variables as needed
    //do not modify the public methods signatures or add public methods
    protected DataOutputStream d;
    int ByteSize = 8;
    int bitCount = 0;

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

        }
        d.write(bit);
    }
    public void close() throws IOException {
        d.close();
    }
}
