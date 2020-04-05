import java.util.Arrays;

public class Test1103 {
    public static int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        Arrays.fill(res, 0);
        int round = 0;
        int remain = candies;
        int sum = (num_people*(num_people+1))/2;
        while(remain>0){
            if(remain>=sum){
                remain = remain-sum;
                round++;
            }else{
                int nth = 1;
                while(remain>= nth + num_people*round){
                    remain = remain - (nth + num_people*round);
                    res[nth-1] = nth + num_people*round;
                    nth++;
                }
                res[nth-1] = remain;
                remain = 0;
            }
            sum += num_people*num_people;

        }
        for(int i = 1; i<=num_people; i++){
            res[i-1] += i*round + num_people*(round*(round-1))/2;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] res = distributeCandies(80, 4);
        for(int i = 0; i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
