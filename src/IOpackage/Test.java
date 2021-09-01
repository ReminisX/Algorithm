package IOpackage;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author l
 */
public class Test{

    public void serializeDemo(String name, int b, int c) throws IOException {
        DemoSon d = new DemoSon(name, b, c);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Demo"));
        oos.writeObject(d);
        oos.flush();
        oos.close();
    }

    public void deSerializeDemo(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        DemoSon d = (DemoSon)ois.readObject();
        System.out.println(d);
    }

    public static class G{
        private int k;

        G(){
            this.k = 0;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<G> l = new ArrayList<>();
        while(true){
            l.add(new G());
        }
    }
}
