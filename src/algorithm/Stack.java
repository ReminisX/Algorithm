package algorithm;

public class Stack {
    private char[] a;  //����ջ
    private int size;  //����ջ��С
    private int top;  //����ջ��λ��
    
    public Stack(int maxsize) {  //������ʼջ��С
        this.size = maxsize;
        this.a = new char[size];
        this.top = -1;
    }
    
    public char peek() {  //��ѯջ����ֵ
        if(this.isEmpty()){
            System.out.println("no available data");
            return 0;
        }
        return a[top];
    }
    
    public void push(char value){  //��ջ
        if(this.isFull()){
            System.out.println("stack is full");
            return ;
        }
        a[++top] = value;
    }
    
    public char pop(){  //��ջ
        if(this.isEmpty()){
            System.out.println("no available data");
            return 0;
        }
        return a[top--];
    }
    
    public int size(){  //ջ�Ĵ�С
        return top+1;
    }
    public boolean isEmpty(){  //�ж�ջ�Ƿ�Ϊ��
        return (top == -1);
    }
    public boolean isFull(){  //�ж�ջ�Ƿ���
        return (top == size -1);
    }
    public void display(){  //��ӡջ
        for(int i = top; i >= 0; i--){
            System.out.println(a[i]+" ");
        }
        System.out.println(" ");
    }
}
