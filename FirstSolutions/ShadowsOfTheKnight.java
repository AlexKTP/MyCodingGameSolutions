import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // Area to find the target
        int[] rows = new int[]{0, W};
        int[] columns = new int[]{0, H};


        
        // game loop
        while (true) {
            String bombDir = in.next();
            System.err.println(bombDir);
            switch(bombDir){
                case "U":
                columns[1] = Y0;
                Y0 = (int) Math.ceil((columns[1] -1 + columns[0]) /2);
                break;
                case "UR":
                columns[1] = Y0;
                Y0 = (int) Math.ceil((columns[1] -1 + columns[0]) /2);
                rows[0] = X0;
                X0 = (int) Math.ceil((rows[0]+1 + rows[1]) /2);
                break;
                case "R":
                rows[0] = X0;
                X0 = (int) Math.ceil((rows[0]+1 + rows[1]) /2);
                break;
                case "DR":
                columns[0] = Y0;
                Y0 = (int) Math.ceil((columns[0] +1 + columns[1]) /2);
                rows[0] = X0;
                X0 = (int) Math.ceil((rows[0]+1 + rows[1]) /2);
                break;
                case "D":
                columns[0] = Y0;
                Y0 = (int) Math.ceil((columns[0] +1 + columns[1]) /2);
                break;
                case "DL":
                columns[0] = Y0;
                Y0 = (int) Math.ceil((columns[0] +1 + columns[1]) /2);
                rows[1] = X0;
                X0 = (int) Math.ceil((rows[1]-1 + rows[0]) /2);
                break;
                case "L":
               rows[1] = X0;
                X0 = (int) Math.ceil((rows[1]-1 + rows[0]) /2);
                break;
                case "UL":
               columns[1] = Y0;
                Y0 = (int) Math.ceil((columns[1]-1 + columns[0]) /2);
                 rows[1] = X0;
                X0 = (int) Math.ceil((rows[1]-1 + rows[0]) /2);
                break;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(X0);
            sb.append(" ");
            sb.append(Y0);
            System.out.println(sb.toString());

        }
    }

}