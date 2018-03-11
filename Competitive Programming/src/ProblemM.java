/**
 * Created by Kenan on 1/24/2018.
 * COMPLETE
 */
import java.io.*;
import java.util.Scanner;
public class ProblemM {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int numCases = scan.nextInt();

        while (numCases > 0) {
            int firstNum = scan.nextInt();
            int secondNum = scan.nextInt();
            int answer = 2 - firstNum + secondNum;
            System.out.println(answer);
            numCases--;
        }
    }
}
