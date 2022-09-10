import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String T = in.nextLine();
        String[] recipes = T.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int number = 0;


        for (String s : recipes) {

            Pattern onlyNumber = Pattern.compile("^[0-9]*$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = onlyNumber.matcher(s);
            boolean onlyNumberFound = matcher.find();
            if (onlyNumberFound) {
                number = Integer.parseInt(s.substring(0, s.length() - 1));
                int numDisplay = Integer.parseInt(s.substring(s.length() - 1, s.length()));
                for (int i = 0; i < number; i++) {
                    sb.append(numDisplay);
                }
            } else {

                Pattern sp = Pattern.compile("sp");
                Matcher m = sp.matcher(s);
                boolean spFound = m.find();

                Pattern bS = Pattern.compile("bS");
                Matcher bSMatch = bS.matcher(s);
                boolean bSFound = bSMatch.find();

                Pattern sQ = Pattern.compile("sQ");
                Matcher sQMatch = sQ.matcher(s);
                boolean sQFound = sQMatch.find();

                Pattern nl = Pattern.compile("nl");
                Matcher nlMatch = nl.matcher(s);
                boolean nlFound = nlMatch.find();

                if (spFound) {
                    String[] arg = s.split("sp");
                    number = Integer.parseInt(arg[0]);

                    for (int i = 0; i < number; i++) {
                        sb.append(" ");
                    }
                } else if (bSFound) {
                    String[] arg = s.split("bS");
                    number = Integer.parseInt(arg[0]);

                    for (int i = 0; i < number; i++) {
                        sb.append("\\");
                    }
                } else if (sQFound) {
                    String[] arg = s.split("sQ");
                    number = Integer.parseInt(arg[0]);

                    for (int i = 0; i < number; i++) {
                        sb.append("'");
                    }
                } else if (nlFound) {
                    sb.append("\n");

                } else {

                    number = Integer.parseInt(s.substring(0, s.length() - 1));

                    for (int i = 0; i < number; i++) {
                        sb.append(s.substring(s.length() - 1, s.length()));
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }

}