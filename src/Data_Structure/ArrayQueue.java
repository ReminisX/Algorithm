package Data_Structure;

public class ArrayQueue {
	private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int k){
        if(isFull()){
            System.out.println("队列满，不能加入...");
            return;
        }
        rear++;
        array[rear] = k;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        front++;
        return array[front];
    }

    //显示队列的所有数据
    public void showQueueAll(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n",i,array[i]);
        }
    }

    //显示队列的头数据
    public int showQueueHead(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        return array[front+1];
    }
}
