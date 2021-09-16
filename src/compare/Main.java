package compare;

import java.util.*;

/**
 * @Author ZhangXD
 * @Date 2021/9/16 11:08
 * @Description
 */
public class Main {

    public static void main(String[] args) {

        Student s1 = new Student("001", "张三", 12);
        Student s2 = new Student("002", "李四", 13);
        Student s3 = new Student("003", "王五", 15);
        Student s4 = new Student("004", "张三", 12);
        Student s5 = new Student("005", "李四", 13);
        Student s6 = new Student("006", "王五", 15);



        List<Student> l = new ArrayList<>();
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        l.add(s5);
        l.add(s6);
        System.out.println("未排序：");
        System.out.println(l);
        Collections.sort(l);
        System.out.println("排序后：");
        System.out.println(l);

    }

}
