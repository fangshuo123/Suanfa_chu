import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Test3601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int[] p;
        int[][] dp;
        int count = 0;//记录2的数量
        int res = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            p = new int[n];
            dp = new int[2*n][n];
            for(int i = 0; i<n; i++){
                p[i] = sc.nextInt();
            }

            for(int i = 0; i<n; i=i+2){
                if(p[i]==1){
                    dp[i][i] = 1;
                    dp[i+1][i] = 1;
                }else if(p[i]==2){
                    dp[i][i] = 1;
                    dp[i+1][i] = 1;
                }
            }
        }
    }

    public void process(Vector<Integer> vec, Vector<Integer> ans, Vector<Vector> res, int index){
        if(index==vec.size()){
            res.add(ans);

        }
        if(vec.get(index)==0){

        }
    }

    public int getValue(int p[], int n){
        int total = 0;
        int day = 0;
        for(int i = 0; i<n; i++){
            if(p[i]==1){
                day++;
                total += day;
            }else{
                day = 0;
            }
        }
        return total;
    }
}
