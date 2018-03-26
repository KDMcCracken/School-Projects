package SubstitutionCypher;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by KDMcC on 3/21/2018.
 */
public class SubstitutionCypher {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        int numCases = Integer.parseInt(scan.nextLine());
        scan.nextLine();
        while(numCases > 0){
            String translated = "";
            HashMap<String, String> keyMap = new HashMap<>();
            String[] alphabet = scan.nextLine().split("");
            String[] cipher = scan.nextLine().split("");

            for(int x = 0; x < alphabet.length; x++){
                keyMap.put(alphabet[x],cipher[x]);
            }

            while(scan.hasNextLine()){
                String LineToTranslate = scan.nextLine();
                if(LineToTranslate.isEmpty()){
                    break;
                }
                String[] words = LineToTranslate.split(" ");
                for(String word : words) {
                    for (String character : word.split("")) {
                        if (keyMap.containsKey(character)) {
                            translated += keyMap.get(character);
                        } else {
                            translated += character;
                        }
                    }
                    translated += " ";
                }
                translated += "\n";
            }
            System.out.println(translated);

            if(numCases > 1){
                scan.nextLine();
            }
            numCases--;
        }
    }
}
