package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TopVotedCandidate {

    private int[] win;

    private int [] time;

    public TopVotedCandidate(int[] persons, int[] times) {
        win = new int[times.length+1];
        time = times;
        win[0] = -1;
        int max = -1;
        // 记录票数
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < persons.length; i++){
            int key = persons[i];
            int val = map.getOrDefault(key, 0) + 1;
            if(val >= max){
                max = val;
                win[i+1] = key;
            }else{
                win[i+1] = win[i];
            }
            map.put(key, val);
        }
    }

    public int q(int t) {
        int index = 0;
        for(int i = 0; i < time.length; i++){
            if(t >= time[i]){
                index = i+1;
            }
        }
        return win[index] == -1 ? null : win[index];
    }

    public static void main(String[] args) {
        int[] persons = new int[]{0,1,1,0,0,1,0};
        int[] times = new int[]{0,5,10,15,20,25,30};
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);

    }

}
