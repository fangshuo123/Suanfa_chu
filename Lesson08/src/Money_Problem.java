//给你一个数组arr，和一个正数aim，
//如果可以任意选择arr中的数字，能不能累加得到aim，返回true或者false
public class Money_Problem {
    //暴力递归
    public static boolean isSum(int[] arr, int i, int sum, int aim ){
        if(i==arr.length){
            return sum==aim;
        }
        return isSum(arr, i+1, sum+arr[i], aim) || isSum(arr, i+1, sum, aim);
    }
    public static boolean money1(int[] arr, int aim){
        return isSum(arr, 0, 0, aim);
    }
    //假设都是正数,改动态规划
    public static boolean money2(int[] arr, int aim){
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        if(sum<aim){
            return false;
        }
        int row = arr.length+1;
        int col = sum+1;
        boolean [][] dp = new boolean[row][col];
        for(int i = 0; i< col; i++){
            if(i==aim){
                dp[row-1][i]=true;
            }else{
                dp[row-1][i]=false;
            }
        }
        for(int i = row-2; i>=0; i--){
            for(int j = 0; j<col; j++){
                if(dp[i+1][j]==true){
                    dp[i][j]=true;
                    if(j-arr[i]>=0){
                        dp[i][j-arr[i]]=true;
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[0][0];


    }



    public static void main(String[] args) {
        int[] arr = { 1, 4,5,2, 8 };
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));

        isSum(arr,0,0,aim);
    }
}
