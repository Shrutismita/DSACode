Q:- https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/
**********************************************************************************************
  //Using DFS(BackTRacking)
  ---------------------------
  class Solution {
    public int numberWays(List<List<Integer>> hats) {
         int n = hats.size();
        Map<Integer,List<Integer>> count  = new HashMap<>();//hatsToPeople
        for(int i=0;i<=40;i++){
            count.put(i,new ArrayList<>());
        }
        for (int i = 0;i<n;i++) {
            List<Integer> h = hats.get(i);
            for(int p : h) {
                count.get(p).add(i);
            }
        }
        char[]initialState = new char[41];
        Map<String,Integer> memo = new HashMap<>();
        return dfs(1,initialState, n,count,memo);
    }
    
    int dfs(int idx,char[]state, int n,Map<Integer,List<Integer>> count,Map<String,Integer> memo) {
        
        int ones = 0;
        for(char c:state){
            if(c=='1') ones++;
            if(ones==n) return 1;// target state
        } 
        
        if (idx > 40) return 0; //base case
        
        String key = new String(idx+"_"+new String(state)); // reuse already computed states
        if(memo.containsKey(key)) return memo.get(key);

        int res = dfs(idx + 1, state,n,count,memo);//do not take this hat
        
        for (int p : count.getOrDefault(idx, new ArrayList<>())) {
            if(state[p]=='1') continue;
            state[p]='1'; //take this hat
            res = (res + dfs(idx + 1, state,n,count,memo)) % ((int) Math.pow(10, 9) + 7);
            state[p]='0'; // backtrack
        }
        memo.put(key,res);
        return res;
    }
}

  
