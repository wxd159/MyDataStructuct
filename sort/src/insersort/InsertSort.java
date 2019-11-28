package insersort;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/27
 * @description: 插入排序：将数组分为有序列表和无序列表
 * @version:1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 6, 4};
        int[] sortArr = insertSort1(arr);
        System.out.println(Arrays.toString(sortArr));
    }

    public static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //找到插入位置
            int index = 0;
            while (index < i) {
                if (arr[index] < arr[i]) {
                    index++;
                } else {
                    break;
                }
            }

            //数据后移
            int insertNum = arr[i];
            for (int j = i; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = insertNum;
        }
        return arr;
    }


    public static int[] insertSort1(int[] arr) {
        int insertindex;
        int insertVal;
        for (int i = 0; i < arr.length; i++) {
            insertindex = i - 1;
            insertVal = arr[i];

            //如果待插入的数比它前面的数小，就进行交换
            while (insertindex >= 0 && arr[insertindex] > insertVal) {
                int temp = arr[insertindex];
                arr[insertindex] = insertVal;
                arr[insertindex + 1] = temp;
                insertindex--;
            }
        }
        return arr;
    }
}
