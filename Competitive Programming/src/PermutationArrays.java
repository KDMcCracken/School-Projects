import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kenan on 2/7/2018.
 * COMPLETED
 */
public class PermutationArrays {
    public static void main(String args[]) throws IOException{
        Scanner scan = new Scanner(new File("test"));
        int cases = scan.nextInt();
        scan.nextLine();
        scan.nextLine();
        while(cases != 0){
            String[] positions = scan.nextLine().split(" ");
            String[] values = scan.nextLine().split(" ");
            int[] foo = convertArray(positions);

            int posTracker = 1;
            for(int x = 0; x < positions.length; x++){
                    if(foo[x] == posTracker){
                        System.out.println(values[x]);
                        posTracker++;
                        x = -1;
                    }
                }
            cases--;
            System.out.println();
            if(scan.hasNextLine()){
                scan.nextLine();
            }
        }
    }

    private static int[] convertArray (String[] array){
        int [] fixed = new int[array.length];
        for(int x = 0; x < array.length; x++){
            String number = array[x];
            fixed[x] = Integer.parseInt(number);
        }
        return fixed;
    }
}
