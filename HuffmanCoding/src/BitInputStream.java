import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Kenan on 3/12/2018.
 */
public class BitInputStream {
    //add additional protected variables as needed
    //do not modify the public methods signatures or add public methods

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
        return d.read();
    }
    public void close() {
    }
}
