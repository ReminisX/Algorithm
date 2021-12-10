package datastructure;

import java.util.List;
import java.util.Stack;

public class StA<E> {

    public void add(List<? extends E> list) {
        System.out.println(list.get(0).getClass());
    }

    public static void main(String[] args) {
        StA<Number> stA = new StA<>();

    }
}
