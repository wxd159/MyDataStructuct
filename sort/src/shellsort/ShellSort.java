package shellsort;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/27
 * @description: 希尔排序，更高效的插入排序，缩小增量
 * @version:1.0
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 6, 4, 2, 0, 5, 8, 7};
        //int[] sortArr = shellSort(arr);
        int[] sortArr = shellSort2(arr);
        System.out.println(Arrays.toString(sortArr));
    }

    //交换法
    public static int[] shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    //移位法
    public static int[] shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int index = i - gap;
                int num = arr[i];
                while(index >= 0 && arr[index] > num){
                    arr[index + gap] = arr[index];
                    arr[index] = num;
                    index -= gap;
                }
            }
        }
        return arr;
    }
}
