public class TestTencent {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        sort(nums, 0 ,nums.length-1);

        int i = 1;
        while(nums[i] != nums[0]){
            i++;
        }
        System.out.println(nums[i]);
    }

    public static void sort(int[] nums, int L, int R){
        if(L<R){
            int[] p = partition(nums, L, R);
            sort(nums, L, p[0]-1);
            sort(nums, p[1]+1, R);
        }
    }
    public static int[] partition (int[] nums, int L, int R){
        int less = L-1;
        int more = R;
        int cur = L;
        while(cur<more){
            if(nums[cur]<nums[R]){
                swap(nums, cur++, ++less);
            }else if(nums[cur]>nums[R]){
                swap(nums, cur, --more);
            }else{
                cur++;
            }
        }
        swap(nums, more, R);
        return new int[]{less++, more};
    }
    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
