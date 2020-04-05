import java.util.Scanner;

public class TestALi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n= sc.nextInt();

        sc.close();
        long ans = 0;
        for(int i = 1; i<=n; i++){
            ans += process(i,n)*i;
        }
        System.out.println(ans);

    }

    public static long process(long up, long down){
        long res = recurrent(down)/recurrent(down-up)/recurrent(up) % 1000000007;
        return res;
    }

    public static long recurrent(long num){
//        if(num<=1){
//            return 1;
//        }else{
//            return num*recurrent(num-1);
//        }
        long temp = 1;
        long res = 1;
        while(num>=temp){
            res = res*temp;
            temp++;
        }
        return res;
    }
}
