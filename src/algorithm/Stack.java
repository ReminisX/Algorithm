package algorithm;

public class Stack {
    private char[] a;  //定义栈
    private int size;  //定义栈大小
    private int top;  //定义栈顶位置
    
    public Stack(int maxsize) {  //构建初始栈大小
        this.size = maxsize;
        this.a = new char[size];
        this.top = -1;
    }
    
    public char peek() {  //查询栈顶的值
        if(this.isEmpty()){
            System.out.println("no available data");
            return 0;
        }
        return a[top];
    }
    
    public void push(char value){  //入栈
        if(this.isFull()){
            System.out.println("stack is full");
            return ;
        }
        a[++top] = value;
    }
    
    public char pop(){  //出栈
        if(this.isEmpty()){
            System.out.println("no available data");
            return 0;
        }
        return a[top--];
    }
    
    public int size(){  //栈的大小
        return top+1;
    }
    public boolean isEmpty(){  //判断栈是否为空
        return (top == -1);
    }
    public boolean isFull(){  //判断栈是否满
        return (top == size -1);
    }
    public void display(){  //打印栈
        for(int i = top; i >= 0; i--){
            System.out.println(a[i]+" ");
        }
        System.out.println(" ");
    }
}
