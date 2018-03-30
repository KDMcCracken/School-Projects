package RootOfTheProblem; /**
 * Created by Kenan on 1/31/2018.
 * INCOMPLETE
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RootOfTheProblem {
    static private int B, N, A;
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("SubstitutionCypherInput"));
        double bestDifference = 0;
        double previousDifference = 17;
        boolean complete = false;
        int count = 1;
        B = scan.nextInt();
        N = scan.nextInt();
        while(B != 0 && N != 0) {
            while (!complete) {
                if(findDifference(count) > previousDifference){
                    complete = true;
                }
                if (findDifference(count) < bestDifference) {
                    bestDifference = findDifference(count);
                    System.out.println("The current best difference is: " + bestDifference);
                }
                count++;
            }
            System.out.println("The best difference found is: " + bestDifference);
            B = scan.nextInt();
            N = scan.nextInt();
        }
    }

    private static double findDifference(int x){
        double difference = 0;
        A = x;
        double compare = Math.pow(A,N);
        if(compare > B){
            difference = compare - B;
        }
        else if(compare < B){
            difference = B - compare;
        }
        return difference;
    }
}
