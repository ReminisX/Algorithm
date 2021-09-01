package test;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {

    public void printDate(int year, int month){
        LocalDate ld = LocalDate.of(year, month, 1);
        LocalDate today = LocalDate.now();
        DayOfWeek week = ld.getDayOfWeek();
        int weekVal = week.getValue();

        // 日历头部打印
        System.out.println("==================" + year + "年" + month + "月" + "===================");
        // 日历星期打印
        System.out.println("Mon    Tue    Wed    Thu    Fri    Sat    Sun");
        // 日历第一行缩进
        for (int i = 1; i < weekVal; i++){
            System.out.print("       ");
        }
        // 循环打印日历
        while(ld.getMonthValue() == month){
            System.out.printf("%3d", ld.getDayOfMonth());
            if (ld.getDayOfMonth() == today.getDayOfMonth()){
                System.out.print("*   ");
            }else{
                System.out.print("    ");
            }
            ld = ld.plusDays(1);
            if (ld.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int year = 2021;
        int month = 7;
        String s = "...";
        Calendar m = new Calendar();
        m.printDate(year, month);
    }

}
