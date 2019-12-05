package fibsearch;

import java.util.Arrays;

/**
 * @author wxd
 * @date Created in 2019/12/4
 * @description: 斐波那契查找（黄金分割法查找）
 * @version:1.0
 * 与二分查找、查找查找的区别是mid的取值不同
 *
 *      二分法  mid = （left + right）/ 2   或者 mid = left + 0.5 * (right - left)
 *      插值查找 mid = left + (right - left) * (findVal - left) / (arr[right] - arr[left])
 *      斐波那契查找 mid = left + fib(n-1)-1     -1的目的是因为数组下标从0开始
 *          F(n)-1 = f(n-1)-1 + F(n-2)-1  把有序数组分为f(n-1)-1 和 F(n-2)-1两个数组 中间值就是left + fib(n-1)-1
 */
public class FibSearch {
    private static int size = 20;
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,8,67,89,133,456,789,890};
        System.out.println(arr.length);
        int a = fibSearch(arr, 890);
        System.out.println(a);
    }

    //生成斐波那契数列
    public static int[] fib(){
        int[] arr = new int[size];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < size; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int fibSearch(int[] arr, int findVal){
        int left = 0;
        int right = arr.length - 1;
        int k = 0;                   //斐波那契数列的下标
        int mid = 0;
        int[] fib = fib();

        //获取斐波那契数列的下标
        while(right > fib[k] -1){
            k++;
        }
        System.out.println(k);

        /*
        因为f[k]的值可能大于arr的长度，因此我们需要使用Arrays类构造一个新的数组
        并指向tmp[] 不足的用0来填充
         */
        int[] tmp = Arrays.copyOf(arr, fib[k]);

        //将填充为0的数据替换成arr数组中的最后一个数据
        for (int i = right + 1; i < tmp.length; i++) {
            tmp[i] = arr[right];
        }

        //查找数据findVal
        while (left <= right){
            mid = left + fib[k - 1] - 1;       //fib[k-1]表示分成两个数组后的前面那个数组元素个数    -1表示下标
            if (findVal == arr[mid]){
                //比较mid与arr长度的大小，判断返回arr最大下标还是mid值
                return mid < arr.length ? mid : arr.length;
            }else if (findVal < arr[mid]){
                //要查找的数在分割点前面的数组
                right = mid - 1;
                //全部元素=前面元素+后面元素  fib[k] = fib[k-1] + fib[k-2]
                k--;
            }else {
                //要查找的数在分割点后面的数组
                left = mid + 1;
                k -= 2;
            }
        }
        return -1;
    }
}
