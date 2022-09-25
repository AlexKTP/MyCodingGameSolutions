import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String operation = in.nextLine();
        int pseudoRandomNumber = in.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        StringBuilder reverse = new StringBuilder();
        String alphabetReverse = reverse.append(alphabet).reverse().toString();
        ArrayList<Character> draft = null;
        ArrayList<Character> result = null;
        ArrayList<String> rotors = new ArrayList();
        String base = "";

        if (in.hasNextLine()) {
            in.nextLine();
        }


        for (int i = 0; i < 3; i++) {
            String rotor = in.nextLine();
            rotors.add(rotor);
        }

        String message = in.nextLine();

        if(operation.equals("ENCODE")){

            int index = 0;
            StringBuilder sb = new StringBuilder();
            for(char c : message.toCharArray()){
                sb.append(alphabet.charAt(getCharToPick(alphabet, c, index, pseudoRandomNumber)));
                index++;
            }

            base = sb.toString();

            for (int j = 0 ; j<rotors.size(); j++){
                draft = new ArrayList();
                if(result == null){
                    result = new ArrayList<>();
                    for(char a : base.toCharArray()){
                        draft.add(rotors.get(j).charAt(alphabet.indexOf(a)));
                    }
                } else {
                    for(char a : result){
                        draft.add(rotors.get(j).charAt(alphabet.indexOf(a)));
                    }
                }
                result = draft;
            }

        } else {

            for (int j = rotors.size()-1; j>=0; j--){
                draft = new ArrayList();

                if(result == null){
                    result = new ArrayList();
                    for(char a : message.toCharArray()){
                        draft.add(alphabet.charAt(rotors.get(j).indexOf(a)));
                    }
                }
                for(char a : result){
                    draft.add(alphabet.charAt(rotors.get(j).indexOf(a)));
                }

                result = draft;

            }
            int index = 0;
            draft = new ArrayList();
            for (char c : result){
                draft.add(alphabetReverse.charAt(getCharToPick(alphabetReverse, c, index, pseudoRandomNumber)));
                index++;
            }

            result = draft;

        }




        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        StringBuilder solution = new StringBuilder();
        for(char c : result){
            solution.append(c);
        }

        System.out.println(solution.toString());
    }

    public static int getCharToPick(String alphabet, char c, int index, int pseudoRandomNumber ){
            int charToPick = alphabet.indexOf(c) + (index + pseudoRandomNumber);
                if( charToPick >=alphabet.length()){
                    charToPick = charToPick % alphabet.length();
                }
                return charToPick;
    }
}