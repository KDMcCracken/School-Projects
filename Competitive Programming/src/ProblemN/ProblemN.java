package ProblemN; /**
 * Created by Kenan on 1/24/2018.
 * INCOMPLETE
 */
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ProblemN {
    static ArrayList<Integer> voteArray = null;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("SubstitutionCypherInput"));
        int totalCases = scan.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int votes = scan.nextInt();

        while (totalCases > 0){
            while (votes > 0){
                int currentVote = scan.nextInt();
                if (hm.containsKey(currentVote)){
                    hm.put(currentVote, hm.get(currentVote) + 1);
                }
                else {
                    hm.put(currentVote, 1);
                }
                votes --;
            }
            int mostVotes = (Collections.max(hm.values()));

            for (Map.Entry<Integer,Integer> entry : hm.entrySet()){
                if(entry.getValue()==mostVotes){
                    System.out.println(entry.getKey());
                }
            }
            totalCases--;
        }


    }

}
