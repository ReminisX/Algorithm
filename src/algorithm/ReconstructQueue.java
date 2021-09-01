package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
	public int[][] reconstructQueue(int[][] people) {
		if(people == null || people.length == 0 || people[0].length == 0) {
			return null;
		}
		Arrays.sort(people, (o1, o2) -> o1 == o2 ? o1[1] - o2[1] : o2[0] - o1[0]);
		List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }
	
	public static void main(String[] args) {
		ReconstructQueue R = new ReconstructQueue();
		int[][] nums = { {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2} };
		int[][] res = R.reconstructQueue(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println();
			for (int j = 0; j < 2; j++) {
				System.out.print(res[i][j]);
			}
		}
	}
	
}
