public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for(int i = 0; i<length; i++){
            for(int j = 0; j<length; j++){
                if(origin.charAt(i)==reverse.charAt(j)){
                    if(i==0 || j==0){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i-1][j-1]+1;
                    }
                }
                if(arr[i][j]>maxLen){
                    int beforeRev = length-j-1;
                    if(beforeRev+arr[i][j]+arr[i][j]-1 == i){
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd-maxLen+1, maxEnd+1);
    }
}
