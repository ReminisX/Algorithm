package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author ZhangXiaodong
 */
public class FindRedundantConnection {

    public int find(int[] parent, int index){
        if(parent[index] != index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public void union(int[] parent, int index1, int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            if(find(parent, edges[i][0]) != find(parent, edges[i][1])){
                union(parent, edges[i][0], edges[i][1]);
            }else{
                return edges[i];
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        FindRedundantConnection F = new FindRedundantConnection();
        int[] res = F.findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }
}
