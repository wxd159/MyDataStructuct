package quicksort;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/27
 * @description: 快排
 * @version:1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-70,35,-89,35,85,-85,64};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static int[] quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right)/2];

        while(l < r){
            //找到左边大于中间值的索引
            while(arr[l] < pivot){
                l++;
            }

            //找到右边小于中间值的索引
            while (arr[r] > pivot){
                r--;
            }

            //把这两个值进行交换
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            l++;
            r--;
        }

        if (l == r){
            l++;
            r--;
        }

        //向左递归
        if (r > left){
            quickSort(arr, left, r);
        }

        //向右递归
        if (l < right){
            quickSort(arr, l, right);
        }

        return arr;
    }
}
