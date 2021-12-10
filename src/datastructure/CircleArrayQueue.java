package datastructure;

class CircleArrayQueue{
    private int maxSize;//��ʾ�����������,ʵ����������Ϊ������-1
    private int front;//����ͷ
    private int rear;//����β
    private int[] arr;//���������ڴ�����ݣ�ģ�����

    //�������еĹ�������ָ�����д�����Ԫ�ظ���
    public CircleArrayQueue(int arrMaxSize){
        //����rear�趨��Ԥ��һ��λ�ã��������Ԫ�ظ���ΪmaxSize-1��ָ����С-1
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//ָ�����ͷ������,��arr[front]��ΪͷԪ��
        rear = 0;//ָ�����β���ݵĺ�һ��λ��,��rear = (rear - 1)%maxSize; arr[rear];��ΪβԪ��
    }

    //�ж϶����Ƿ���
    public boolean isFull(){
        //return (rear + 1 + maxSize - front ) % maxSize == 0;// ���ַ���Ч����ͬ
        return (rear + 1) % maxSize == front;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty(){
        return rear == front;
    }

    //������ݵ�����
    public void addQueue(int n){
        //�����ж϶����Ƿ���
        if(isFull()){
            System.out.println("�����������ܼ���...");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //��ȡ���е����ݣ�������
    public int getQueue(){
        //�ж϶����Ƿ�Ϊ��
        if(isEmpty()){
            //ͨ���׳��쳣�������쳣���Զ�return �Ͳ����ֶ�return�ж���
            throw new RuntimeException("���пգ�����ȡ������...");
            //�������return������ֵ������ܻ�����Ϊ�Ƕ�����Ԫ��
        }
        int value = arr[front];
        front = (front + 1) % maxSize;//front����
        return value;
    }

    //��ʾ���е���������
    public void showQueue(){
        //����
        if(isEmpty()){
            System.out.println("���пգ��޷���ʾ����...");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            //��Ϊfront+size()���ܻᳬ�������С��������Ҫȡģ
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //��ʾ���е�ͷ���ݣ�ֻ����ʾ��������ȡ��
    public int headQueue(){
        //�ж�
        if(isEmpty()){
            //ͨ���׳��쳣�������쳣���Զ�return �Ͳ����ֶ�return�ж���
            throw new RuntimeException("���пգ�û��ͷ����...");
        }
        return arr[front];
    }

    //��ȡ�������ݸ�����С
    public int size(){
        // rear = 1; front = 2; maxSize = 3;Ϊ�� �洢����Ϊ����[0][2]��������0��ʼ ���ռ�Ϊ3
        return (rear + maxSize - front) % maxSize;
    }

    //��ʾβԪ��
    public int rearQueue(){
        if(isEmpty()){
            throw new RuntimeException("���пգ�û��β����...");
        }
        return arr[(rear - 1 + maxSize)%maxSize];
    }
}
