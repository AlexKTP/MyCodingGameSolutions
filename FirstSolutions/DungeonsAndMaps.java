import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int mapToChoose = -1;
        char[][] map = new char[h][w];
        int n = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[] m = null;

        for (int i = 0; i < n; i++) {
        
            for (int j = 0; j < h; j++) {
                String mapRow = in.nextLine();
                m = mapRow.toCharArray();
    
                for(int k = 0; k<m.length; k++){
                    map[j][k] = m[k];
                }
            }

            if(m!= null){
                sum = find(map, startRow, startCol, h, w, 0, startRow, startCol);
                if(sum<min && sum>0) {
                    min = sum;
                    mapToChoose = i;
                }
            }
        }

        System.out.println(mapToChoose>-1 ? mapToChoose: "TRAP");
    }

    static int find(char[][] arr, int newRow, int newCol, int h, int w, int sum, int startR, int startC){

        if(newRow> w-1 || newCol>h-1) return -1;

        if(sum>0 && startC == newCol && startR == newRow){
            return -1;
        } 

        char c = arr[newRow][newCol];

        switch(c){
            case '.':
            return -1;
            case '#':
            return -1;
            case '>':
            if(newCol+1>w) return -1;
            else {
                newCol+=1;
                sum+=1;
                return find(arr, newRow, newCol, h, w, sum, startR, startC);
            }
            case 'v':
            if(newRow+1>h) return -1;
            else {
                newRow+=1;
                sum+=1;
                return find(arr, newRow, newCol, h, w, sum, startR, startC);
            }
            case '<':
            if(startC-1<0) return -1;
            else {
                newCol-=1;
                sum+=1;
                return find(arr, newRow, newCol, h, w, sum, startR, startC);
            }
            case '^':
             if(newRow-1<0) return -1;
            else {
                newRow-=1;
                sum+=1;
               return find(arr, newRow, newCol, h, w, sum, startR, startC);
            }
            case 'T':
            return sum;
            default:
            return sum;
        }
    }
}