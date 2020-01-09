package arrayqueue;

/**
 * @author wxd
 * @date Created in 2019/12/5
 * @description: 用数组模拟队列
 * @version:1.0
 *
 * 注：该队列是一次性的，在出队后，队空，但不能添加数据，会显示队满
 */
public class ArrayQueue {
    //数组长度
    private int maxSize;
    //指向队首 front是指向队列头的前一个位置
    private int front;
    //指向队尾  指向队列尾部的数据
    private int rear;
    private int[] arr;

    ArrayQueue(int maxSize){
        this.maxSize =maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == maxSize;
    }

    //入队
    public void addQueue(int num){
        if (isFull()) {
            System.out.println("队列已满，不能入队！");
        }else{
            arr[++rear] = num;
        }
    }

    //出队
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能出队！");
        }else{
            return arr[front++];
        }
    }

    //显示数组中的数据 如果队列为空，则不显示数据，不为空则显示数组中的数据（不是队列中的数据）
    public void show(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
        } else {
            for (int i = 0; i < maxSize; i++) {
                System.out.printf("arr[%d] = %d\n",i, arr[i]);
            }
        }
    }

    //显示队首数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空！");
        }else {
            return arr[++front];
        }
    }
}
