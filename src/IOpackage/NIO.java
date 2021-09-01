package IOpackage;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Zhangxiaodong
 * @createtime 2021年1月19日16:59:32
 */
public class NIO {

    public static void main(String[] args) {
        RandomAccessFile aFile = null;
        try {
            aFile = new RandomAccessFile("D:\\IDEA\\IDEA_workspace\\Algorithm\\src\\IOpackage\\123.txt", "r");
            FileChannel fc = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(16);
            int byteRead = fc.read(buf);
            System.out.println(byteRead);
            while(byteRead != -1){
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char)buf.get());
                }
                buf.compact();
                byteRead = fc.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
