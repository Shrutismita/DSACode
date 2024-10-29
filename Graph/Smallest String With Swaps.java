Q:- https://leetcode.com/problems/smallest-string-with-swaps/description/
********************************************************************************************
  //Using DSU
  ----------------------------------------------------
  class Pair{
    char d;
    int index;
    public Pair(char d,int index){
          this.d=d;
          this.index=index;

    }
}
class Solution {
    static int[] rank;
    static int[] parent;
    public static int  find(int i){
        if(i==parent[i]){
            return i;
        }
        return parent[i]=find(parent[i]);
    }
    public static void Union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
        if (xParent != yParent) {
            if (rank[xParent] < rank[yParent]) {
                parent[xParent] = yParent;
            } else if (rank[yParent] < rank[xParent]) {
                parent[yParent] = xParent;
            } else {
                parent[yParent] = xParent;
                rank[xParent]++;
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        rank=new int[s.length()];
        parent=new int[s.length()];
        for(int i=0;i<s.length();i++){
            rank[i]=0;
            parent[i]=i;
        }
        int n=s.length();
        char[] ans=new char[n];
        HashMap<Integer,ArrayList<Pair>> hs=new HashMap<>();
        for(List<Integer> pair:pairs){
            if(find(pair.get(0))!=find(pair.get(1))){
                Union(pair.get(0),pair.get(1));
            }
        }
        for(int i=0;i<s.length();i++){
            if(hs.containsKey(find(i))){
                hs.get(find(i)).add(new Pair(s.charAt(i),i));
            }
            else{
                hs.put(find(i),new ArrayList<>());
                hs.get(find(i)).add(new Pair(s.charAt(i),i));
            }
        }
        for(Map.Entry<Integer,ArrayList<Pair>> am:hs.entrySet()){
            List<Integer> l=new ArrayList<>();
            List<Character> arr=new ArrayList<>();
            ArrayList<Pair> m=am.getValue();
            for(Pair n1:m){
                l.add(n1.index);
                arr.add(n1.d);
            }
            Collections.sort(l);
            Collections.sort(arr);
            int k=0;
            for(Integer a:l){
                ans[a]=arr.get(k);
                k++;
            }

        }
        return new String(ans);

    }
}
