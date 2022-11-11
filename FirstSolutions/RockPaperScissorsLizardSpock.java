import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        HashMap<Integer, String> pick = new HashMap();
        HashMap<String, String> rules = new HashMap();
        HashMap<Integer, List<Integer>> history = new HashMap<>();
        rules.put("CP", "C");
        rules.put("PR", "P");
        rules.put("LR", "R");
        rules.put("LS", "L");
        rules.put("CS", "S");
        rules.put("CL", "C");
        rules.put("LP", "L");
        rules.put("PS", "P");
        rules.put("RS", "S");
        rules.put("CR", "R");

        String alpha = "CLPRS";
        ArrayList<Integer> currentRound = new ArrayList();
        ArrayList<Integer> nextRound = new ArrayList();

        for (int i = 0; i < N; i++) {
            int NUMPLAYER = in.nextInt();
            String SIGNPLAYER = in.next();
            pick.put(NUMPLAYER, SIGNPLAYER);
            currentRound.add(NUMPLAYER);
        }

        while (currentRound.size() > 1) {
            nextRound = new ArrayList();
            for (int i = 0; i < currentRound.size(); i++) {
                if (i + 1 < currentRound.size()) {

                
                    String valueP1 = pick.get(currentRound.get(i));
                    String valueP2 = pick.get(currentRound.get(i + 1));

                    
                    int index1 = alpha.indexOf(valueP1);
                    int index2 = alpha.indexOf(valueP2);
                    
                    StringBuilder rule = new StringBuilder();
                    rule.append(index1 < index2 ? valueP1 : valueP2);
                    rule.append(index1 < index2 ? valueP2 : valueP1);
                    if (index1 == index2) {
                        rule.append(valueP1);
                        rule.append(valueP2);
                    }


                    String resultFight = null;

                    if (index1 == index2) {
                    } else resultFight = rules.get(rule.toString());

                    int winner = -1;

                    if (resultFight == null) {
                        winner = currentRound.get(i) < currentRound.get(i + 1) ? currentRound.get(i) : currentRound.get(i + 1);
                        nextRound.add(currentRound.get(i) < currentRound.get(i + 1) ? currentRound.get(i) : currentRound.get(i + 1));
                    } else if (resultFight.equals(valueP1)) {
                        winner = currentRound.get(i);
                        nextRound.add(currentRound.get(i));
                    } else {
                        winner = currentRound.get(i + 1);
                        nextRound.add(currentRound.get(i + 1));
                    }

                    List<Integer> h = null;
                    if (history.get(winner) == null) {
                        h = new ArrayList();
                    } else h = history.get(winner);

                    h.add(winner == currentRound.get(i) ? currentRound.get(i + 1) : currentRound.get(i));
                    history.put(winner, h);

                    i++;
                }
            }
            currentRound = nextRound;

            if (currentRound.size() == 1) {

                StringBuilder result = new StringBuilder();
                result.append(String.valueOf(currentRound.get(0)));
                System.out.println(result.toString());

            }
        }

        StringBuilder result = new StringBuilder();
        for (Integer i : history.get(nextRound.get(0))) {
            result.append(i);
            result.append(" ");
        }
        String res = result.toString().substring(0, result.toString().length()-1);
        System.out.println(res);
    }
}