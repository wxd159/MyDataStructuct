package bubble;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/27
 * @description: 冒泡排序 依次比较相邻的值，逆序则交换（大的沉底）
 * @version:1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,6,4};
        int[] sortArr = bubbleSort(arr);
        System.out.println(Arrays.toString(sortArr));
    }

    public static int[] bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //如果发现有一趟排序过程中，一次交换都没有，则说明已经是有序的
            if (!flag) break;
        }
        return arr;
    }
}
