package effective;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * effectiveJava page 126
 */
public class HeapPollution {

    /**
     * 不安全的泛型类型
     * @param args
     * @param <T>
     * @return
     */
    static <T> T[] toArray(T... args){
        return args;
    }

    static <T> List<T> flatten(List<? extends T>... lists){
        List<T> result = new ArrayList<>();
        for(List<? extends T> list : lists){
            result.addAll(list);
        }
        return result;
    }

    static <T> T[] pickTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(Arrays.toString(attributes));
    }

}
