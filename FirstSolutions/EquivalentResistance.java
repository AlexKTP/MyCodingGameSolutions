import java.util.*;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> resistances = new HashMap<String, Integer>();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String name = in.next();
            int R = in.nextInt();
            resistances.put(name, R);
        }
        in.nextLine();
        String circuit = in.nextLine();
        
        for (String i : resistances.keySet()){
            circuit = circuit.replaceAll(i, resistances.get(i).toString());
        }

       
        int idxParal = -1;
        int indexSerie = -1;

        while(circuit.contains("[") || circuit.contains("(")){

        StringBuilder sb = new StringBuilder();
        sb.append(circuit);
        sb.reverse();
        String circuitReversed = sb.toString();
        
            idxParal = circuitReversed.indexOf("[");
            indexSerie = circuitReversed.indexOf("(");

            boolean isInSerie = false;
            
            isInSerie = (indexSerie >=0 && indexSerie<idxParal) ||idxParal <0;
            idxParal = isInSerie ? indexSerie : idxParal;        

            String serie = null;
                if(idxParal == circuit.length()-1){
                    serie = circuit;
              } else{
                    String chunk = circuit.substring(circuit.length()-1-idxParal);
                    int x = chunk.indexOf(isInSerie ? ")" : "]");
                    serie = chunk.substring(0, x+1);
            } 

                String[] split = serie.split(" ");
                circuit = circuit.replace(serie, calculation(split, isInSerie));

        }

        double d = Double.valueOf(circuit);
        DecimalFormat f = new DecimalFormat("##.0");
        System.out.println(f.format(d));
    }

    private static String calculation(String[] doubles, boolean isInSerie){
        if(isInSerie){
            double d =0;
            for (String s : doubles){
              if((s.matches("\\d+") || s.matches("\\d+\\.\\d+"))) {
                 d += Double.valueOf(s);
              } 
            }
            return String.valueOf(d);
        } else {
            List<Double> subArray = new ArrayList();
            double d =0;
            for(String s : doubles){
                
            if((s.matches("\\d+") || s.matches("\\d+\\.\\d+") )) {
                subArray.add(1/Double.valueOf(s));
              }
            } 

            for(Double doub : subArray){
                d += doub;
            }
            
            return String.valueOf(1/d);

        }
    }

}