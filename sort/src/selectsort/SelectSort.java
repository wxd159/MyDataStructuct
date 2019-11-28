package selectsort;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/27
 * @description: 选择排序：选出每轮最小的元素往前放
 * @version:1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,4};
        int[] sortArr = selectSort(arr);
        System.out.println(Arrays.toString(sortArr));
    }

    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }
}
