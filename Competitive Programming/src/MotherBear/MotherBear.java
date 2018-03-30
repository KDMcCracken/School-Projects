package MotherBear;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by Kenan on 2/7/2018.
 * COMPLETE
 */
public class MotherBear{
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(new File("src/MotherBear/MotherBearInput"));
        String sentence = scan.nextLine();
        while(!sentence.equals("DONE")){
            String[] input = sentence.split("");
            String[] reversed = reverse(input);
            input = arrayCleanUp(input);
            reversed = arrayCleanUp(reversed);
            if(compareArrays(input,reversed)){
                System.out.println("You won't be eaten!");
            }else{
                System.out.println("Uh oh..");
            }
            sentence = scan.nextLine();
        }
    }

    private static String[] reverse(String[] input){
        String[] reversed = new String[input.length];
        int count = 0;
        for(int x = input.length-1; x >= 0; x--){
            reversed[count] = input[x];
            count++;
        }
        return reversed;
    }

    private static boolean compareArrays(String[] array1, String[] array2){
        for(int x = 0; x < array1.length; x++){
            if(!array1[x].equals(array2[x])){
                return false;
            }
        }
        return true;
    }

    private static String[] arrayCleanUp(String[] fixThis){
        ArrayList<String> clean = new ArrayList<>();
        for(int x = 0; x < fixThis.length; x++){
            if(fixThis[x].equals(".") || fixThis[x].equals(",") || fixThis[x].equals("!")
                    || fixThis[x].equals("?") || fixThis[x].equals(" ")){
                continue;
            }else{
                clean.add(fixThis[x].toUpperCase());
            }
        }
        return clean.toArray(new String[clean.size()]);
    }
}
