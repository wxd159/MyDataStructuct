package insertsearch;

/**
 * @author wxd
 * @date Created in 2019/12/3
 * @description: 插值查找
 * @version:1.0
 * 插值查找和二分查找的区别是mid的取值不同
 *      二分法  mid = （left + right）/ 2   或者 mid = left + 0.5 * (right - left)
 *      插值查找 mid = left + (right - left) * (findVal - left) / (arr[right] - arr[left])
 *
 *  对于数据量大，数据分布比较均匀的情况，用插值查找会比较好
 *  * 在数据分布不均匀的情况下，插值查找不一定比二分快
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int index = insertValueSearch(arr, 10, 0, arr.length - 1);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr, int findVal, int left, int right){
        int mid = left + (right - left) * (findVal - left) / (arr[right] - arr[left]);
        if (left > right || findVal > arr[right] || findVal < arr[left]){
            return -1;
        }
        if (findVal == arr[mid]){
            return mid;
        }else if (findVal < arr[mid]){
            return insertValueSearch(arr, findVal, left, mid - 1);
        }else{
            return insertValueSearch(arr, findVal, mid + 1, right);
        }
    }
}
