public class Cow {
    public static int cowNumber(int n){
        if(n<1){
            return 0;
        }
        if(n==1 || n==2 || n==3){
            return n;
        }
        return cowNumber(n-1) + cowNumber(n-3);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(cowNumber(n));

    }
}
