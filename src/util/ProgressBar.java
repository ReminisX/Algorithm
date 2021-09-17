package util;

/**
 * @Author ZhangXD
 * @Date 2021/9/17 11:31
 * @Description 控制台进度条
 */
public class ProgressBar {

    private final int BAR_LENGTH = 30;



    public ProgressBar() {

    }

    public void deleteLine(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print('\b');
        }
    }

    public void showBar(String name, double percent) {
        StringBuilder sb = new StringBuilder(BAR_LENGTH);
        sb.append(name);
        sb.append(":");
        sb.append("[");
        // 计算当前进度条长度
        int startIndex = name.length() + 2;
        int k = (int)(percent * BAR_LENGTH) + 1;
        for (int i = 0; i < k; i++) {
            sb.append("=");
        }
        // 尾部计算
        for (int i = startIndex + k; i < startIndex + BAR_LENGTH; i++) {
            sb.append(" ");
        }
        sb.append("]");
        sb.append(String.format("%.2f", percent*100 + 1));
        sb.append("%");


        // 删除当前行数据
        deleteLine(name.length() + 9 + BAR_LENGTH);
        // 展示进度条
        System.out.print(sb);
    }

    public static void main(String[] args) throws InterruptedException {
        ProgressBar pb = new ProgressBar();
        for (int i = 0; i < 100; i++) {
            double percent = (double)i / 100;
            pb.showBar("任务一", percent);
            Thread.sleep(100);
        }

    }
}
