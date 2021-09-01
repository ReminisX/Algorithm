package IOpackage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author l
 */ //服务器
public class Server implements Runnable {

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9050);
            Socket socket;
            DataInputStream in;
            DataOutputStream out;
            while (true) {
                // 等待client的请求
                System.out.println("Server is running, waiting for Client...");
                socket = server.accept();
                // 接收客户端的数据
                in = new DataInputStream(socket.getInputStream());
                String ss = in.readUTF();
                if (ss.equals("bb")) {
                    socket.close();
                    break;
                }
                // 发送给客户端数据
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("return____" + ss);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server serverApp = new Server();
        serverApp.run();
    }
}
