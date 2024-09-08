Q:- 77. https://leetcode.com/problems/combinations/

T.C - O(C(n, k))(Not getting how to write 
  S.C - O(n)
  ============================================================
  class Solution {
    List<List<Integer>> result = new ArrayList<>();;
    void solve(int start, int n,int k,List<Integer> temp)
    {
        if(k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= n; i++) {
            temp.add(i);
            solve(i+1, n, k-1, temp);
            temp.remove(temp.size() - 1);
        }    
        }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        solve(1,n,k,temp);
        return result;
    }
}
