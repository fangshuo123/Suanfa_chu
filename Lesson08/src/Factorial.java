public class Factorial {
    public static long getFactorial(int n){
        if(n==1){
            return 1L;
        }
        return n*getFactorial(n-1);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFactorial(n));

    }
}
