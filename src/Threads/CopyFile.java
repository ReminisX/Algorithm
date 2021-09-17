package Threads;

import java.io.*;

/**
 * @Author ZhangXD
 * @Date 2021/9/17 9:58
 * @Description
 */
public class CopyFile {

    class CopyThread implements Runnable {

        private String srcPath;
        private String destPath;
        private long startIndex;
        private long endIndex;
        //构造函数：
        public CopyThread(String srcPath, String destPath, long startIndex, long endIndex) {
            this.srcPath = srcPath;//源文件路径
            this.destPath = destPath;//目的路径
            this.startIndex = startIndex;//开始位置
            this.endIndex = endIndex;//结束位置
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": 复制中...");
            long startTime = System.currentTimeMillis();
            try(RandomAccessFile srcFile = new RandomAccessFile(srcPath,"r");
                RandomAccessFile destFile = new RandomAccessFile(destPath, "rw"); ) {
                //指针移到指定位置
                srcFile.seek(startIndex);
                destFile.seek(startIndex);
                //标志读取的起始位置
                long index = startIndex;
                //读取内容到数组
                byte[] bytes = new byte[1024];
                int n;
                //读到文件结尾
                while ((n = srcFile.read(bytes)) != -1){
                    //更新读取的位置
                    index += n;
                    //将读的数组写入目的路径
                    destFile.write(bytes,0,n);
                    //读到当前线程的范围结尾处
                    if(index >= endIndex){
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "线程运行时间：" + (endTime - startTime) + "ms");
        }
    }

    public void copyFile(String srcPath, String destPath, int threadNum) {
        if (threadNum < 1) {
            System.out.println("线程数设置错误！");
            return;
        }
        long startTime = System.currentTimeMillis();
        File f = new File(srcPath);
        long fileSize = f.length();
        long threadFileSize = fileSize / threadNum;
        long cutPoint = 0;

        CopyThread copyThreads;
        for (int i = 0; i < threadNum - 1; i++) {
            copyThreads = new CopyThread(srcPath, destPath, cutPoint, cutPoint + threadFileSize);
            cutPoint = cutPoint + threadFileSize + 1;
            copyThreads.run();
        }
        CopyThread subCopyThread = new CopyThread(srcPath, destPath, cutPoint, fileSize);
        subCopyThread.run();
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        CopyFile copyFile = new CopyFile();
        copyFile.copyFile("E:\\Fork\\Algorithm\\src\\Threads\\123.txt", "E:\\Fork\\Algorithm\\src\\Threads\\345.txt", 4);
    }

}
