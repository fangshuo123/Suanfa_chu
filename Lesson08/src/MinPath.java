//给你一个二维数组，二维数组中的每个数都是正数，
//要求从左上角走到右下角，每一步只能向右或者向下。
//沿途经过的数字要累加起来
//返回最小的路径和。

//改动态规划的条件：当递归展开时由重复状态，并且这个状态与到达他的路径无关时
public class MinPath {
    //暴力递归1
    public static int walk(int[][] matrix, int i, int j){
        if(i==matrix.length-1 && j==matrix[0].length-1){
            return matrix[i][j];
        }
        if(i==matrix.length-1){
            return matrix[i][j]+walk(matrix,i,j+1);
        }
        if(j==matrix[0].length-1){
            return matrix[i][j]+walk(matrix,i+1,j);
        }
        int right = walk(matrix,i,j+1);
        int down = walk(matrix,i+1,j);
        return matrix[i][j]+Math.min(right,down);
    }
    public static int minPath1(int[][] matrix){
        return walk(matrix,0,0);
    }

    //改动态规划1
    public static int minPath11(int[][] m){
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = m[row-1][col-1];
        for(int i = row-2; i>=0; i--){
            dp[i][col-1] = m[i][col-1] + dp[i+1][col-1];
        }
        for(int j = col-2; j>=0; j--){
            dp[row-1][j] = m[row-1][j] + dp[row-1][j+1];
        }
        for(int i = row-2; i>=0; i--){
            for(int j = col-2; j>=0; j--){
                dp[i][j] = m[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }


    //暴力递归2
    public static int process(int[][] matrix, int i, int j){
        int res = matrix[i][j];
        if(i==0 && j==0){
            return res;
        }
        if(i==0 && j != 0){
            return res+process(matrix,i,j-1);
        }
        if(j==0 && i != 0){
            return res+process(matrix,i-1,j);
        }
        return res+Math.min(process(matrix,i-1,j), process(matrix,i,j-1));
    }
    public static int minPath2(int[][] matrix){
        return process(matrix, matrix.length-1, matrix[0].length-1);
    }
    //改动态规划2
    public static int minPath22(int[][] m){
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for(int i = 1;i<row;i++){
            dp[i][0] = m[i][0]+dp[i-1][0];
        }
        for(int j = 1;j<col;j++){
            dp[0][j] = m[0][j]+dp[0][j-1];
        }
        for(int i = 1; i<row; i++){
            for(int j = 1; j<col; j++){
                dp[i][j] = m[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[row-1][col-1];

    }



    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
        System.out.println(minPath11(m));
        System.out.println(minPath22(m));


        m = generateRandomMatrix(6, 7);
        System.out.println(minPath1(m));
        System.out.println(minPath2(m));
        System.out.println(minPath11(m));
        System.out.println(minPath22(m));



    }
}
