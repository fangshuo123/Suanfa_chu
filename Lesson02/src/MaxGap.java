import java.util.Arrays;
//找到数组中 若排序后两个数之间的最大差值
public class MaxGap {
    public static int maxGap(int[] nums){
        if(nums == null || nums.length<2){
            return 0;
        }
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< length; i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if(min==max){
            return 0;
        }
        boolean[] hasNum = new boolean[length+1];
        int[] maxs = new int[length+1];
        int[] mins = new int[length+1];
        int bid = 0;
        for(int i = 0; i<length;i++){
            bid = bucket(nums[i], length, min ,max);//???为什么是length
            mins[bid] = hasNum[bid] ? Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid],nums[i]):nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for(;i<=length;i++){
            if(hasNum[i]){
                res = Math.max(res, mins[i]-lastMax);
                lastMax = maxs[i];
            }

        }
        return res;
    }
    public static int bucket(long num, long len, long min, long max){
        return (int)((num-min)*len/(max-min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 1;
//        int maxSize = 100;
//        int maxValue = 100;
//        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandomArray(maxSize, maxValue);
//            int[] arr2 = copyArray(arr1);
//            if (maxGap(arr1) != comparator(arr2)) {
//                succeed = false;
//                break;
//            }
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        int[] arr1 = {2,4,5,8};
        System.out.println(maxGap(arr1));
    }

}
