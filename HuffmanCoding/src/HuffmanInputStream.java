import java.io.IOException;

/**
 * Created by Kenan on 3/12/2018.
 */
public class HuffmanInputStream extends BitInputStream {
    //add additional private variables as needed
    //do not modify the public method signatures or add public methods
    private String tree;
    private int totalChars;

    public HuffmanInputStream(String filename) {

        super(filename);
        try {
            tree = d.readUTF();
            totalChars = d.readInt();
        } catch (IOException e) {
        }
    }

    public String getTree() {
        return tree;
    }

    public int getTotalChars() {
        return totalChars;
    }
}
