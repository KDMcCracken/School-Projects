import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Kenan on 2/28/2018.
 * INCOMPLETE
 * Works for only 0,1,2....supposed to work for ALL possible distances
 */
public class SurprisingStrings {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] lineArray = line.split(""); // Creates an array of all individual letters
            //Handles any input that is one letter
            if(lineArray.length < 1){
                System.out.println(lineArray[0] + " is surprising.");
            }
            String [] zeroUniqueArray = uniqueArray(lineArray,0);
            String [] oneUniqueArray = uniqueArray(lineArray,1);
            String [] twoUniqueArray = uniqueArray(lineArray,2);
            boolean zero = testUnique(zeroUniqueArray);
            boolean one = testUnique(oneUniqueArray);
            boolean two = testUnique(twoUniqueArray);
            if(zero && one && two){
                System.out.println(line + " is surprising.");
            }
            else{
                System.out.println(line + " is NOT surprising.");
            }
        }
    }

    private static String[] uniqueArray(String[] line, int num){
        ArrayList<String> foo = new ArrayList<>();
        if(num == 0) {
            for (int x = 0; x < line.length - 1; x++) {
                foo.add(line[x] + line[x + 1]);
            }
            return foo.toArray(new String[0]);
        }
        if(num == 1){
            for (int x = 0; x < line.length - 2; x++) {
                foo.add(line[x] + line[x + 2]);
            }
            return foo.toArray(new String[0]);
        }
        for (int x = 0; x < line.length - 3; x++) {
            foo.add(line[x] + line[x + 3]);
        }
        return foo.toArray(new String[0]);
    }

    private static boolean testUnique(String [] bar){
        for(int x = 0; x < bar.length; x++){
            String position = bar[x];
            for(int y = 0; y < bar.length; y++){
                if(y==x){
                    continue;
                }
                if(bar[y].equals(position)){
                    return false;
                }
            }
        }
        return true;
    }
}
