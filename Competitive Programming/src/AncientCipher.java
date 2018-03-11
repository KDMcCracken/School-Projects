import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.*;

/**
 * Created by Kenan on 2/21/2018.
 * INCOMPLETE
 */
public class AncientCipher {
    public static void main(String args[]) throws IOException{
        Scanner scan = new Scanner(new File("test"));
        while(scan.hasNextLine()) {
            String[] first = scan.nextLine().split("");
            String[] second = scan.nextLine().split("");
            HashMap<String,Integer> firstMap = createMap(first);
            HashMap<String,Integer> secondMap = createMap(second);

            pleaseWork(firstMap,secondMap);
            if(firstMap.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static HashMap<String,Integer> createMap(String[] array){
        HashMap<String,Integer> map = new HashMap<>();
        for(int x = 0; x < array.length; x++){
            if(map.containsKey(array[x])){
                map.put(array[x],map.get(array[x])+1);
            }else{
                map.put(array[x],1);
            }
        }
        return map;
    }

    public static void printMap(HashMap<String, Integer> map){
        for(Map.Entry<String,Integer> entry1 : map.entrySet()){
            System.out.println(entry1.getKey() + " " + entry1.getValue());
        }
    }

    public static void pleaseWork(Map first, Map second) {
        Set set = first.entrySet();
        Iterator iterator = set.iterator();
        Set set2 = second.entrySet();
        Iterator iterator2 = set2.iterator();

        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            while(iterator2.hasNext()) {
                //System.out.println(mentry);
                Map.Entry mentry2 = (Map.Entry)iterator2.next();
                //System.out.println(mentry2);
                if(mentry.getValue() == mentry2.getValue()){
                    System.out.println("Removing: " + first.get(mentry) + " and " + second.get(mentry));
                    first.remove(mentry);
                    second.remove(mentry2);
                    break;
                }
            }
            iterator2 = set2.iterator();
        }
    }
}
