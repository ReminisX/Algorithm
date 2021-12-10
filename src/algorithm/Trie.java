package algorithm;

import java.util.HashMap;
import java.util.Map;

class Trie {
	// ָ�����д��ڵ���һ���ַ�
    private Map<Character, Map> map;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        map = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Map<Character, Map> ws = map;
        for (int i = 0; i < word.length(); i++) {
            ws.putIfAbsent(word.charAt(i), new HashMap<>());
            ws = ws.get(word.charAt(i));
        }
        ws.put('.', null);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Map<Character, Map> ws = map;
        for (int i = 0; i < word.length(); i++) {
            ws = ws.get(word.charAt(i));
            if (ws == null) {
                return false;
            }
        }
        return ws.containsKey('.');
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Map<Character, Map> ws = map;
        for (int i = 0; i < prefix.length(); i++) {
            ws = ws.get(prefix.charAt(i));
            if (ws == null) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
