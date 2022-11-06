import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int countX = in.nextInt();
        int countY = in.nextInt();
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        int numberOfSquare = 0;

        for (int i = 0; i < countX; i++) {
            x.add(in.nextInt());
            
        }
        
        x.add(w);

        int[] xbis = x.stream().mapToInt(i->i).toArray();

        for (int i = 0; i < countY; i++) {
            y.add(in.nextInt());
        }

        y.add(h);


        for(int i=0; i<xbis.length; i++){
            for(int j=i+1; j<xbis.length; j++){
                x.add(xbis[j]-xbis[i]);
            }
        }

        x.sort(Comparator.naturalOrder());


        int[] ybis = y.stream().mapToInt(i->i).toArray();

        
    for (int i = 0; i<ybis.length; i++){
        for (int j = i+1; j<ybis.length; j++){
            y.add(ybis[j] - ybis[i]);
        }
    } 

    y.sort(Comparator.naturalOrder());


    for(int i : x){
        for (int j : y){
            if(i==j) numberOfSquare++;
            else if (i<j) break;
        }
    }

    System.out.println(numberOfSquare);

    }
}