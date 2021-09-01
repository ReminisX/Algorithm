package algorithm;

import java.util.*;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(!map.containsKey(key)) {
            	map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
	
	public static void main(String[] args) {
		GroupAnagrams G = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> L = G.groupAnagrams(strs);
		for(List<String> l : L) {
			for(String s : l) {
				System.out.print(s);
			}
			System.out.println();
		}
	}
}
