package algorithm;

import java.util.*;

/**
 * @author ZhangXiaodong
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        class UnionFind
        {
            int[] parent;
            int[] rank;
            public UnionFind(int n)
            {
                parent = new int[n];
                rank = new int[n];
                init();
            }
            public void init()
            {
                for (int i = 0; i < parent.length; i++)
                {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }
            public int find(int i)
            {
                int rec = i;
                while (parent[rec] != rec)
                {
                    rec = parent[rec];
                }
                int orig;
                while (i != rec)
                {
                    orig = parent[i];
                    parent[i] = rec;
                    i = orig;
                }
                return i;
            }
            public void union(int p, int q)
            {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return ;
                if (rank[rootP] > rank[rootQ])
                {
                    parent[rootQ] = rootP;
                    rank[rootP] += rank[rootQ];
                }
                else
                {
                    parent[rootP] = rootQ;
                    rank[rootQ] += rank[rootP];
                }
            }
        }

        int size = accounts.size();
        UnionFind un = new UnionFind(size);
        HashMap<Integer, TreeSet<String>> mailTOname = new HashMap<>();
        HashMap<String, Integer> mailToIndex = new HashMap<>();
        for(int i = 0; i < size; i++)
        {
            List<String> account = accounts.get(i);
            int mailSize = account.size();
            for (int indexOfmail = 1; indexOfmail < mailSize; indexOfmail++)
            {
                String mail = account.get(indexOfmail);
                if (mailToIndex.containsKey(mail))
                {
                    un.union(mailToIndex.get(mail), i);
                }
                mailToIndex.put(mail, i);
            }
        }

        for(int i = 0; i < size; i++)
        {
            int root = un.find(i);
            List<String> account = accounts.get(i);
            List<String> mailList = accounts.get(i).subList(1, accounts.get(i).size());
            if (mailTOname.containsKey(root)) mailTOname.get(root).addAll(mailList);
            else mailTOname.put(root, new TreeSet(mailList));
        }

        List<List<String>> ans = new ArrayList<>();
        for (int key : mailTOname.keySet())
        {
            String name = accounts.get(key).get(0);
            TreeSet<String> mails = mailTOname.get(key);
            List<String> tmp = new ArrayList<>();
            tmp.add(name);
            tmp.addAll(mails);
            ans.add(tmp);
        }
        return ans;
    }


    public static void main(String[] args) {
        AccountsMerge A = new AccountsMerge();
        List<List<String>> accounts = new ArrayList<List<String>>();
        accounts.add(new ArrayList<>(Arrays.asList("john", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        List<List<String>> res = A.accountsMerge(accounts);
        System.out.println(res);
    }
}
