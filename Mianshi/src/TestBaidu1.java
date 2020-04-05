import java.util.Scanner;

public class TestBaidu1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arrA = null;
        int[] arrB = null;
        int ans = 0;
        while(sc.hasNext()){
            int num = sc.nextInt();
            int c = sc.nextInt();
            for(int i = 0; i<num; i++){
                arrA[i] = sc.nextInt();
            }
            for(int i = 0; i<num; i++){
                arrB[i] = sc.nextInt();
            }

            for(int i = 0; i<c; i++){
                int max = 0;
                for(int j = 0; j<num; j++){
                    int sum = 0;
                    for(int k = 0; k<num; k++){
                        if(k!=j)
                            sum+=arrA[k]-arrB[k];
                    }
                    max = Math.max(max, sum + arrA[j]);
                }
                ans +=max;
            }

        }
        sc.close();

    }
}

