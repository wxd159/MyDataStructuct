package binarysearch;

/**
 * @author wxd
 * @date Created in 2019/12/1
 * @description:
 * @version:1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12,56,234,678,788,4297};
//        int index = BinarySearch(arr, 12);
        int index = BinarySearch1(arr,788, 0, arr.length - 1);
        System.out.println(index);
    }

    /**
     * 非递归方式
     * @param arr
     * @param num
     * @return
     */
    public static int BinarySearch(int[] arr, int num){
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right)/2;

        while(mid > left || mid <right){
            if (num == arr[mid]){
                return mid;
            }

            if(num > arr[mid]){
                left = mid;
            }else{
                right = mid;
            }
            mid = (left + right)/2;
        }
        return -1;
    }

    /**
     * 二分查找递归实现
     * @param arr
     * @param num
     * @return
     */
    public static int BinarySearch1(int[] arr, int num, int left, int right){
        int mid = (left + right)/2;
        if (num == arr[mid]){
            return mid;
        }else if (num < arr[mid]){
            return BinarySearch1(arr, num, left, mid);
        }else{
            return BinarySearch1(arr, num, mid, right);
        }
    }

}
