import java.util.Scanner;

public class TestYuanjing2 {


    public static void main(String[] args) {
        int[] number;
        int[] grad;
        int n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n = sc.nextInt();
            number = new int[n];
            grad = new int[n];
            for(int i = 0; i<n; i++){
                number[i] = sc.nextInt();
                grad[i] = sc.nextInt();
            }
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n-i-1;j++){
                    if(grad[j]>grad[j+1]){
                        int tem = grad[j];
                        grad[j] = grad[j+1];
                        grad[j+1] = tem;

                        tem = number[j];
                        number[j] = number[j+1];
                        number[j+1] = tem;
                    }else if(grad[j]==grad[j+1]){
                        if(number[j]>number[j+1]){
                            int tem = number[j];
                            number[j] = number[j+1];
                            number[j+1] = tem;
                        }
                    }
                }
            }
            for(int i = 0; i<n; i++){
                System.out.println(number[i]+" "+grad[i]);
            }
        }

        sc.close();
    }
}
