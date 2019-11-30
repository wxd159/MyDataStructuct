package radixsort;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/30
 * @description: 基数排序，桶排序
 * @version:1.0
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //获取arr中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //获取最大值的位数
        int length = ("" + max).length();
        System.out.println("数组中最大值的位数是：" + length);

        //定义一个二维数组 表示10个桶，每个桶是一个一维数组
        //arr.length表示极端情况下，所有的数都在一个桶里面
        int[][] bucket = new int[10][arr.length];

        //定义一个一维数组，表示每个桶中的数据个数
        int[] count = new int[10];

        for (int i = 0, n = 1; i < length; n *= 10, i++) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][count[digitOfElement]] = arr[j];
                count[digitOfElement]++;
            }
            System.out.println("i==" + i);

            //遍历二维数组，把二维数组中的数据放回原数组中
            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
                if (count[j] != 0){
                    for (int k = 0; k < count[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                    count[j]=0;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
