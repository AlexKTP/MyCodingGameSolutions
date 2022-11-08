import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String b = in.nextLine();
        int sum = 0;
        int max = 0;
        int currentSerie = 0;
        if(b == null) max = 0;
        else if(b.length()<2 && b.charAt(0) == '1') max = 1;
        else {
            char[] arr = b.toCharArray();
            boolean jokerUsed = false;
            for(int i = 0; i<arr.length; i++){

                if(arr[i] == '1'){
                    sum++;
                    currentSerie++;
                } 

                else{

                    if(!jokerUsed && i+1<arr.length && sum == 0 && arr[i+1]=='1'){
                        jokerUsed = true;
                        sum++;
                        currentSerie = 0;
                    }

                    else if(!jokerUsed && i+1<arr.length && sum>0 && arr[i+1] == '1'){
                        sum++;
                        jokerUsed = true;
                        currentSerie = 0;
                    } 
                    
                    else if (jokerUsed && i+1<arr.length  && arr[i+1] == '1'){
                        sum = currentSerie;
                        currentSerie = 0;
                        sum++;

                    }
                    
                    else if (!jokerUsed && i+1<arr.length && sum>0 && arr[i+1] == '0') {
                        sum++;
                        if(max<sum) max = sum;
                        sum = 0;
                        jokerUsed = false;
                        currentSerie = 0;
                    } 
                    
                    else {
                        currentSerie = 0;
                        jokerUsed = true;
                        sum =0;
                    }
                }
                if(max<sum) max = sum;
            }
        }

        System.out.println(max > 0 ? max : 1);
    }
}