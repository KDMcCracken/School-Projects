package Quicksum;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Kenan on 1/31/2018.
 * COMPLETE
 */
public class Quicksum {
    //static Scanner scan = new Scanner(new File("SubstitutionCypherInput.txt"));
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        String[] array = new String[]{" ","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S",
                "T","U","V","W","X","Y","Z"};
        HashMap<String, Integer> map = new HashMap<>(26);
        for(int x = 0; x < array.length; x++ ){
            map.put(array[x],x);
        }

        String currentString = scan.nextLine();
        while(!currentString.equals("#")){
            String[] input = currentString.split("");
            computeOutput(input,map);
            currentString = scan.nextLine();
        }
    }

    private static void computeOutput(String[] input, HashMap<String, Integer> map){
        int totalValue = 0;
        for(int x = 0; x < input.length; x++){
            totalValue += (map.get(input[x]) * (x+1));
        }
        System.out.println(totalValue);
    }
}
