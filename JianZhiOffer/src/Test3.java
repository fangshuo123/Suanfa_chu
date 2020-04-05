//在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
// 数组中某些数字是重复的，
// 但不知道有几个数字是重复的，
// 也不知道每个数字重复几次。
// 请找出数组中任意一个重复的数字。
public class Test3 {
    public static boolean duplicate(int[] arr, int[] duplication){
        for(int i = 0; i<arr.length; i++){

            while(arr[i]!=i){
                if(arr[i] == arr[arr[i]]){
                    duplication[0] = arr[i];
                    return true;
                }else{
                    swap(arr, i, arr[i]);
                }
            }
        }
        return false;
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,3,4,1,2,4};
        int[] duplication = new int[1];
        System.out.println(duplicate(arr,duplication));
        System.out.println(duplication[0]);
    }
}
