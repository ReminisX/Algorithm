package algorithm;

public class MedianFinder {

    class Node{
        int val;
        Node next;
        Node pre;
        public Node(){}
        public Node(int val){
            this.val = val;
        }
    }

    private Node last;

    private Node leftMid;

    private Node rightMid;

    private int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.last = new Node();
        leftMid = last;
        rightMid = last;
        this.size = 0;
    }

    public void addNum(int num) {
        // 设立flag
        int flag = 0;
        // 节点部署至末尾
        Node node = new Node(num);
        // 第一个节点加入时
        if (size == 0){
            ++size;
            last = node;
            leftMid = node;
            rightMid = node;
            return;
        }
        last.next = node;
        node.pre = last;
        last = last.next;
        ++size;
        // 节点遍历至指定位置
        while(node.pre != null && node.val < node.pre.val){
            // 判断是否与中位数节点进行交换
            if(node.pre == rightMid){
                ++flag;
                rightMid = rightMid.next;
            }
            if(node.pre == leftMid){
                ++flag;
                leftMid = leftMid.next;
            }
            // 节点前移
            int temp = node.val;
            node.val = node.pre.val;
            node.pre.val = temp;
            node = node.pre;
        }
        // 中位数移动
        if(size % 2 == 1){
            if(flag == 0){
                leftMid = leftMid.next;
            }else if(flag == 1){
                leftMid = leftMid.next;
                rightMid = rightMid.pre;
            }else{
                rightMid = rightMid.pre;
            }
        }else{
            if(flag == 0){
                rightMid = rightMid.next;
            }else{
                leftMid = leftMid.pre;
            }
        }
    }

    public double findMedian() {
        return (double)leftMid.val/2 + (double)rightMid.val/2;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(2);
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
