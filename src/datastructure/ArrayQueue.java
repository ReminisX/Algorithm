package datastructure;

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

    //�ж϶����Ƿ���
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty(){
        return rear == front;
    }

    //������ݵ�����
    public void addQueue(int k){
        if(isFull()){
            System.out.println("�����������ܼ���...");
            return;
        }
        rear++;
        array[rear] = k;
    }

    //��ȡ���е����ݣ�������
    public int getQueue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        front++;
        return array[front];
    }

    //��ʾ���е���������
    public void showQueueAll(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n",i,array[i]);
        }
    }

    //��ʾ���е�ͷ����
    public int showQueueHead(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return 0;
        }
        return array[front+1];
    }
}
