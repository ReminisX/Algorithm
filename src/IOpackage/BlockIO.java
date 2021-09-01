package IOpackage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author l
 */
public class BlockIO {
    public static void main(String[] args) {
        InputStream in =  null;
        try {
            in = new BufferedInputStream(new FileInputStream("D:\\IDEA\\IDEA_workspace\\Algorithm\\src\\IOpackage\\123.txt"));
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1){
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char)buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
