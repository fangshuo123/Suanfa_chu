public class SmallSum {
    public static int smallSum(int[] arr){
        if(arr==null||arr.length<2){
            return 0;
        }
        return mergeSort(arr, 0, arr.length-1);
    }
    public static int mergeSort(int[] arr, int L , int R){
        if(L==R){
            return 0;
        }
        int mid = (L+R)/2;
        return mergeSort(arr, L, mid)+mergeSort(arr,mid+1,R)+merge(arr, L, mid, R);
    }
    public static int merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = mid+1;
        int i = 0;
        int sum = 0;
        while(p1<=mid && p2 <= R){
            sum += arr[p1]<arr[p2] ? arr[p1]*(R-p2+1):0;
            help[i++] = arr[p1]<arr[p2] ? arr[p1++]:arr[p2++];
        }
        if(p1<=mid ){
            help[i++] = arr[p1++];
        }
        if(p2<=R){
            help[i++] = arr[p2++];
        }
        for(i=0;i<=help.length-1;i++){
            arr[L+i] = help[i];
        }
        return sum;

    }
}
