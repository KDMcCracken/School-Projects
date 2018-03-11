import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kenan on 2/14/2018.
 * COMPLETE
 */
public class FreeSpots {
    public static void main(String args[]) throws IOException{
        Scanner scan = new Scanner(new File("test"));
        int cols = scan.nextInt();
        int rows = scan.nextInt();
        int N = scan.nextInt();

        while(cols != 0 && rows != 0){
            int[][] board = buildEmptyBoard(cols,rows);
            for(int x = 0; x < N; x++){
                fillSubRectangles(board,scan.nextInt()-1,scan.nextInt()-1,scan.nextInt()-1,scan.nextInt()-1);
            }
            if(countEmptySpots(board) == 0){
                System.out.println("There is no empty spots.");
            }
            else if(countEmptySpots(board) == 1){
                System.out.println("There is one empty spot.");
            }
            else {
                System.out.println("There are " + countEmptySpots(board) + " empty spots.");
            }
            scan.nextLine();
            cols = scan.nextInt();
            rows = scan.nextInt();
            N = scan.nextInt();
        }
    }

    private static int countEmptySpots(int[][] board){
        int emptySpots = 0;
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                if(board[x][y] == -1){
                    emptySpots++;
                }
            }
        }
        return emptySpots;
    }


    private static void fillSubRectangles(int[][] board, int x1, int y1, int x2, int y2){
        if(x2 < x1){
            int tmp = x2;
            x2 = x1;
            x1 = tmp;
        }
        if(y2 < y1){
            int tmp = y2;
            y2 = y1;
            y1 = tmp;
        }
        for(int y = y1; y <= y2; y++){
            for(int x = x1; x <= x2; x++){
                board[y][x] = 1;
            }
        }
    }

    private static int[][] buildEmptyBoard(int columns, int rows){
        int[][] board = new int[rows][columns];
        for(int x = 0; x < rows; x++){
            for(int y = 0; y < columns; y++){
                board[x][y] = -1;
            }
        }
        return board;
    }
}
