import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Map<String, String> inputs = new HashMap<String, String>();
        List<String> results = new ArrayList<>();
        int lenght = 0;

        for (int i = 0; i < n; i++) {
            String inputName = in.next();
            String inputSignal = in.next();
            lenght = inputSignal.length();
            inputs.put(inputName, inputSignal);
        }
        for (int i = 0; i < m; i++) {
            StringBuilder res = new StringBuilder();
            String outputName = in.next();
            String type = in.next();
            String inputName1 = in.next();
            String inputName2 = in.next();
            char under = "_".charAt(0);
            char middle = "-".charAt(0);

            res.append(outputName);
            res.append(" ");

            for(int j = 0; j<lenght; j++){

                switch(type){
                    case "AND":
                        if(inputs.get(inputName1).charAt(j) ==  under || inputs.get(inputName2).charAt(j) == under){
                            res.append(under);
                        } else res.append(middle);
                        break;
                    case "OR":
                        if(inputs.get(inputName1).charAt(j) == under && inputs.get(inputName2).charAt(j) == under){
                            res.append(under);
                        } else res.append(middle);
                        break;
                    case "XOR":
                        if(inputs.get(inputName1).charAt(j) == middle && inputs.get(inputName2).charAt(j) == middle){
                            res.append(under);
                        }
                        else if(inputs.get(inputName1).charAt(j) == under && inputs.get(inputName2).charAt(j) == under){
                            res.append(under);
                        } else res.append(middle);
                        break;
                    case "NAND":
                        if(inputs.get(inputName1).charAt(j) ==  under || inputs.get(inputName2).charAt(j) == under){
                            res.append(middle);
                        } else res.append(under);
                        break;
                    case "NOR":
                        if(inputs.get(inputName1).charAt(j) == under && inputs.get(inputName2).charAt(j) == under){
                            res.append(middle);
                        } else res.append(under);
                        break;
                    case "NXOR":
                        if(inputs.get(inputName1).charAt(j) == middle && inputs.get(inputName2).charAt(j) == middle){
                            res.append(middle);
                        }
                        else if(inputs.get(inputName1).charAt(j) == under && inputs.get(inputName2).charAt(j) == under){
                            res.append(middle);
                        } else res.append(under);
                        break;
                }


            }

            results.add(res.toString());

        }

        for (int i = 0; i < m; i++) {
            System.out.println(results.get(i));
        }
    }
}