public class test33 {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0){
            return -1;
        }
        if(n==1){
            return nums[0]==target ? 0:-1;
        }
        int rotateIndex = findRotateIndex(nums);
        System.out.println("rotateIndex:"+rotateIndex);
        if(rotateIndex==0){
            return search(nums, 0, n-1, target);
        }
        if(nums[0]>target){
            return search(nums, rotateIndex, n-1, target);
        }else{
            return search(nums, 0, rotateIndex-1, target);
        }


    }

    public static int findRotateIndex(int[] nums){
        int left = 0;
        int right = nums.length-1;
        if(nums[left]<nums[right]){
            return 0;
        }
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]>nums[mid+1]){
                return mid+1;
            }
            if(nums[left]<nums[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return 0;
    }
    public static int search(int[] nums, int left, int right, int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,9,1,3,4};
        int target = 9;
        int res = search(nums,target);
        System.out.println(res);


    }
}
