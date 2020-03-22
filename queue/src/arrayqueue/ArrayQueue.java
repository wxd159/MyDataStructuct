package arrayqueue;

import java.util.Scanner;

/**
 * @author wxd
 * @date Created in 2019/12/5
 * @description: 用数组模拟队列
 * @version:1.0
 *
 * 注：该队列是一次性的，在出队后，队空，但不能添加数据 ，会显示队满
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
        return rear == maxSize - 1;
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



class Test{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key= ' ';   //接受用户输入
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while (loop){
            System.out.println("-----------------------");
            System.out.println("s(show):");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):入队");
            System.out.println("g(get):出队");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("请输入你的操作");

            key = sc.next().charAt(0);

            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("请输入要添加的数据：");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());         //输出异常信息
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("取出的头数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    System.out.println("你的输入有误");
            }
        }
    }
}
