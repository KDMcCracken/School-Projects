import java.io.IOException;

/**
 * Created by Kenan on 3/12/2018.
 */
public class HuffmanOutputStream extends BitOutputStream {
    public HuffmanOutputStream(String filename, String tree, int totalChars) {

        super(filename);
        try {
            d.writeUTF(tree);
            d.writeInt(totalChars);
        }
        catch (IOException e) {
        }
    }
}
