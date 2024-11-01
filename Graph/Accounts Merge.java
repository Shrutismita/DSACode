Q:- https://leetcode.com/problems/accounts-merge/
**********************************************************************
  //Using DSU
  ----------------------------------
  class Solution {
      int[] parent;
    int[] rank;
    
    public int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        if (rank[px] > rank[py]) {
            parent[py] = px;
            rank[px]++;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
    
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n = accounts.size();
        
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0 ; i < n ; i++) parent[i] = i;
        
        Map<String, Integer> mailMap = new HashMap<>();
        
        for (int i = 0 ; i < n ; i++) {
            
            int m = accounts.get(i).size();
            
            for (int j = 1 ; j < m ; j++) {
                
                String mailAddress = accounts.get(i).get(j);
                
                if (!mailMap.containsKey(mailAddress)) {
                    mailMap.put(mailAddress, i);
                } else {
                    union(i, mailMap.get(mailAddress)); // unioning ith index with the index where we encountered the same mail earlier.
                }
            }
        }
        
        
        Map<Integer, Set<String>> distinctGroupMap = new HashMap<>();
        
        for (int i = 0 ; i < n ; i++) {
            parent[i] = find(i); // further updating the parent in case of anyting left earlier
            
            int accountSize = accounts.get(i).size();
            distinctGroupMap.putIfAbsent(parent[i], new HashSet<>());
            distinctGroupMap.get(parent[i]).addAll(accounts.get(i).subList(1, accountSize)); // removing 0th element which is name
        }
        
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        for (int group : distinctGroupMap.keySet()) {
            List<String> emailList = new ArrayList<>(distinctGroupMap.get(group));
            Collections.sort(emailList);
            
            emailList.add(0, accounts.get(group).get(0)); // adding the name to the first element of the merged account
            mergedAccounts.add(emailList);
        }
        
        return mergedAccounts;
    }
}
