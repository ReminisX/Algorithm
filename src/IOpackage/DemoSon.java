package IOpackage;

import java.io.*;

class DemoSon implements Serializable {
    public transient String name;
    public int b;
    public transient int c;

    public DemoSon(String name, int b, int c){
        this.name = name;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name=" + name +
                ", b=" + b +
                ", c=" + c +
                '}';
    }


}
