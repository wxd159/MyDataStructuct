package merge;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/11/27
 * @description: 归并排序（分治算法）：将数组递归分为最小的有序集合，再将有序集合合并为一个有序集合
 * @version:1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {-70,35,-89,35,85,-85,64};
        int[] sort = mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] mergeSort(int[] arr, int left, int right, int[] tmp){
        int[] result = null;

        if (left < right){

            int mid = (left + right)/2;

            //向左递归分解为最小的集合
            mergeSort(arr, left, mid, tmp);

            //向右递归分解为最小的集合
            mergeSort(arr, mid + 1, right, tmp);

            //将两个有序集合合并成一个有序集合
            result = merge(arr, left, mid, right, tmp);
        }
        return result;
    }

    /**
     * 两个有序数组合并成一个有序数组（左边、右边两个数组）
     * @param arr  排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param tmp   做中转的数组
     */
    public static int[] merge(int arr[], int left, int mid, int right, int[] tmp){
        int l = left;
        int r = mid + 1;

        //将两个数组中较小的数放到临时数组中
        int index = 0;
        while(l <= mid && r <= right){
            if (arr[l] <= arr[r]){
                tmp[index] = arr[l];
                l++;
            }else{
                tmp[index] = arr[r];
                r++;
            }
            index++;
        }

        //将左边数组中的剩余元素放到临时数组中
        while(l <= mid){
            tmp[index] = arr[l];
            l++;
            index++;
        }
        //将右边数组中的剩余元素放到临时数组中
        while (r <= right){
            tmp[index] = arr[r];
            r++;
            index++;
        }


        //将临时数组中的数据放到arr中
        //注意：不是每次都拷贝所有
        int tmpLeft = left;
        index = 0;
        while (tmpLeft <= right){
            arr[tmpLeft] = tmp[index];
            index++;
            tmpLeft++;
        }
        return arr;
    }
}
