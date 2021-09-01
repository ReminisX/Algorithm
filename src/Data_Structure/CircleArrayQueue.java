package Data_Structure;

class CircleArrayQueue{
    private int maxSize;//表示数组最大容量,实际容纳数量为此数量-1
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用于存放数据，模拟队列

    //创建队列的构造器，指定队列存放最大元素个数
    public CircleArrayQueue(int arrMaxSize){
        //由于rear设定会预留一个位置，其可容纳元素个数为maxSize-1。指定大小-1
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部数据,即arr[front]即为头元素
        rear = 0;//指向队列尾数据的后一个位置,即rear = (rear - 1)%maxSize; arr[rear];即为尾元素
    }

    //判断队列是否满
    public boolean isFull(){
        //return (rear + 1 + maxSize - front ) % maxSize == 0;// 两种方法效果相同
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //首先判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入...");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //通过抛出异常，由于异常会自动return 就不用手动return中断了
            throw new RuntimeException("队列空，不能取出数据...");
            //如果采用return返回数值，则可能会误认为是队列中元素
        }
        int value = arr[front];
        front = (front + 1) % maxSize;//front后移
        return value;
    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if(isEmpty()){
            System.out.println("队列空，无法显示数据...");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            //因为front+size()可能会超过数组大小，所以需要取模
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //显示队列的头数据，只是显示，并不是取出
    public int headQueue(){
        //判断
        if(isEmpty()){
            //通过抛出异常，由于异常会自动return 就不用手动return中断了
            throw new RuntimeException("队列空，没有头数据...");
        }
        return arr[front];
    }

    //获取队列数据个数大小
    public int size(){
        // rear = 1; front = 2; maxSize = 3;为例 存储数据为两个[0][2]，索引从0开始 最大空间为3
        return (rear + maxSize - front) % maxSize;
    }

    //显示尾元素
    public int rearQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空，没有尾数据...");
        }
        return arr[(rear - 1 + maxSize)%maxSize];
    }
}
