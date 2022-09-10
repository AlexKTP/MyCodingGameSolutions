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
        int W = in.nextInt();
        int H = in.nextInt();
        HashMap<String, Integer> hash = new HashMap();
        List<String> headers = new ArrayList();
        List<String> footers = new ArrayList();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < H; i++) {
            String line = in.nextLine();

            // Storing headers
            if (i == 0) {
                String[] l = line.split("  ");
                if (l != null && l.length > 0) {
                    int index = 0;
                    for (int j = 0; j < l.length; j++) {
                        if (l[j] != null && l[j] != "") {
                            hash.put(l[j], index);
                            headers.add(l[j]);
                            index++;
                        }
                    }
                }

                // Storing  footers
            } else if (i == H - 1) {
                String[] l = line.split("  ");
                if (l != null && l.length > 0) {
                    for (int j = 0; j < l.length; j++) {
                        if (l[j] != null && l[j] != "") {
                            footers.add(l[j]);
                        }
                    }

                }

                // Algotithm 
            } else {

                while (line.indexOf("--") > -1 && i != H - 1) {
                    for (Map.Entry<String, Integer> set : hash.entrySet()) {
                        line = line.replaceAll("  ", "");
                        if (line.indexOf("--") > -1 && set.getValue() == line.indexOf("--") - 1) {
                            if (hash.size() >= set.getValue() + 1) {
                                set.setValue(set.getValue() + 1);
                            }
                        } else if (line.indexOf("--") > -1 && set.getValue() == line.indexOf("--")) {
                            set.setValue(set.getValue() - 1);
                        }
                    }
                    line = line.replaceFirst("--", "");

                }
            }
        }

        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (String header : headers) {
            sb.append(header);
            sb.append(footers.get(hash.get(header)));
            if (index < hash.size()) {
                sb.append("\n");
            }
            index++;
        }
        System.out.println(sb.toString());
    }


}