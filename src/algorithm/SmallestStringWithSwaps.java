package algorithm;

import java.util.*;
public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>(2 * pairs.size());
        for (List<Integer> pair : pairs)
        {
            int nodeA = pair.get(0), nodeB = pair.get(1);
            List<Integer> list = graph.getOrDefault(nodeA, null);
            if (list == null)
            {
                list = new ArrayList<>();
                graph.put(nodeA, list);
            }
            list.add(nodeB);
            list = graph.getOrDefault(nodeB, null);
            if (list == null)
            {
                list = new ArrayList<>();
                graph.put(nodeB, list);
            }
            list.add(nodeA);
        }//construct graph

        StringBuilder sb = new StringBuilder(s);
        boolean[] visited = new boolean[s.length()];
        for (int i = 0;i < s.length();i++)
        {
            if (!visited[i])
            {
                Queue<Integer> queue = new LinkedList<>();
                List<Integer> subGraph = new ArrayList<>();
                visited[i] = true;
                queue.offer(i);
                subGraph.add(i);
                while (!queue.isEmpty())
                {
                    int nodeA = queue.poll();
                    List<Integer> list = graph.getOrDefault(nodeA, null);
                    if (list == null)   continue;
                    for (Integer nodeB : list)
                    {
                        if (!visited[nodeB])
                        {
                            visited[nodeB] = true;
                            queue.offer(nodeB);
                            subGraph.add(nodeB);
                        }
                    }
                }
                List<Integer> temp = new ArrayList<>(subGraph);
                Collections.sort(subGraph);
                Collections.sort(temp, (a, b) -> {
                    return s.charAt(a) - s.charAt(b);
                });
                for (int j = 0;j < subGraph.size();j++)
                {
                    sb.setCharAt(subGraph.get(j), s.charAt(temp.get(j)));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        SmallestStringWithSwaps S = new SmallestStringWithSwaps();
        String s = "cba";
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        pairs.add(Arrays.asList(0, 1));
        pairs.add(Arrays.asList(1, 2));
        String res = S.smallestStringWithSwaps(s, pairs);
        System.out.println("the final result is:" + res);
    }
}
