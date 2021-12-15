package algorithm;

import java.util.*;

public class LoudAndRich {

    public int[] loudAndRich1(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[][] w = new int[n][n];
        int[] in = new int[n];
        for (int[] r : richer) {
            int a = r[0], b = r[1];
            w[a][b] = 1; in[b]++;
        }
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (in[i] == 0) d.addLast(i);
        }
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int u = 0; u < n; u++) {
                if (w[t][u] == 1) {
                    if (quiet[ans[t]] < quiet[ans[u]]) ans[u] = ans[t];
                    if (--in[u] == 0) d.addLast(u);
                }
            }
        }
        return ans;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // 节点个数
        int n = quiet.length;
        // 定义邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        // 定义节点入度
        int[] in = new int[n];
        // 计算节点入度和邻接表
        for (int[] ints : richer) {
            int key = ints[0];
            int val = ints[1];
            ++in[val];
            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(val);
                map.put(key, l);
            }
        }
        // 定义队列
        Queue<Integer> queue = new LinkedList<>();
        // 定义结果集
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            // 初始化结果集
            res[i] = i;
            // 入度为0的入队
            if (in[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int t = queue.poll();
            for (int u : map.getOrDefault(t, new ArrayList<>())) {
                if(quiet[res[t]] < quiet[res[u]]){
                    res[u] = res[t];
                    if (--in[u] == 0){
                        queue.add(u);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] richer = new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = new int[]{3, 2, 5, 4, 6, 1, 7, 0};
        LoudAndRich loudAndRich = new LoudAndRich();
        int[] res = loudAndRich.loudAndRich1(richer, quiet);
        System.out.println(Arrays.toString(res));
    }

}
