public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {4,3,7,8,1,6};
        //BubbleSort.bubblesort(arr);
        //SelectionSort.selectionsort(arr);
        //InsertSort.insertSort(arr);
        //MergeSort.mergeSort(arr);
        int smallSum = SmallSum.smallSum(arr);
        for(int a :arr){
            System.out.print(a);
        }
        System.out.println();
        System.out.println(smallSum);
    }
}
