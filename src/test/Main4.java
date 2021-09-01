package test;

import java.util.Scanner;

public class Main4 {

    class Tree{
        int val;
        Tree left;
        Tree right;
    }

    public int[] tree(String s){
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9'){
                if (left != i){
                    String sub = s.substring(left, i);
                }

            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Math.random());
    }
}
