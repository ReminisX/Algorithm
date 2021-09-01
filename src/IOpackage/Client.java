package IOpackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        System.out.println("Let's Go...");
        Socket socket;
        String p;
        DataInputStream in;
        DataOutputStream out;
        Scanner scanner;
        while (true) {
            try {
                socket = new Socket("localhost", 9050);
                scanner = new Scanner(System.in);
                p = scanner.nextLine();
                // 发送给服务器的数据
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(p);
                if (p.equals("bb")) {
                    socket.close();
                    break;
                }
                // 接收服务器的返回数据
                in = new DataInputStream(socket.getInputStream());
                System.out.println("return" + in.readUTF());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
