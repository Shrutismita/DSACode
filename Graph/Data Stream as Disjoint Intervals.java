Q:- https://leetcode.com/problems/data-stream-as-disjoint-intervals/
********************************************************************************
  //Using DSU
 // n - number of values added
//d - number of unique disjoint intervals

//Time complexity: addNum: O(1) amortized based on path compression and shallowness of parent tree

//getIntervals: O(dlogd + d) = O(dlogd) assuming there are d disjoint intervals

//Space complexity: O(3n + d) = O(n) to store references to all added numbers in the map
 ---------------------------------------------------------------------------------------------------
  class SummaryRanges {

    class DisjointInterval {
        int min;
        int max;
        int val;
        public DisjointInterval(int min, int max, int val) {
            this.min = min;
            this.max = max;
            this.val = val;
        }
    }
    Map<Integer, DisjointInterval> parent;
    Map<Integer, Integer> rank;
    Set<DisjointInterval> intervals;

    public SummaryRanges() {
      parent = new HashMap<>();
      rank = new HashMap<>();
      intervals = new HashSet<>();
    }

    public void addNum(int value) {
      if (parent.containsKey(value)) return;
      //1. create current value interval
      DisjointInterval newAdd = new DisjointInterval(value, value, value);
      parent.put(value, newAdd);
      rank.put(value, 1);

      //2. union neighbor intervals
      union(parent, rank, value-1, value);
      union(parent, rank, value+1, value);
      
      //3. add the union parent to set of disjoint intervals
      intervals.add(find(parent, value));
    }
    
    public int[][] getIntervals() {
      int[][] result = new int[intervals.size()][2];
      int idx = 0;

      //1. get all disjoint intervals
      for (DisjointInterval interval : intervals) {
        result[idx][0] = interval.min;
        result[idx++][1] = interval.max;
      }
      //2. sort by each interval's start time
      Arrays.sort(result, (a,b) -> a[0] - b[0]);
      return result;
    }

    private DisjointInterval find(Map<Integer, DisjointInterval> parent, int node) {
      if (!parent.containsKey(node)) return null;
      DisjointInterval p = parent.get(node);
      while (p != parent.get(p.val)) {
        parent.put(p.val, find(parent, p.val));
        p = parent.get(p.val);
      }
      return p;
    }

    private boolean union(Map<Integer, DisjointInterval> parent, Map<Integer, Integer> rank, int node1, int node2) {
      DisjointInterval p1 = find(parent, node1);
      DisjointInterval p2 = find(parent, node2);
      if (p1 == null || p2 == null) return false; //cannot union something not in set
      if (p1 == p2) return false; //already unioned

      //update min/max 
      p1.min = Math.min(p1.min, p2.min);
      p1.max = Math.max(p1.max, p2.max);
      p2.min = p1.min;
      p2.max = p1.max;
      
      //update parent, rank, and disjoint intervals set
      if (rank.get(p1.val) >= rank.get(p2.val)) {
        parent.put(p2.val, p1);
        rank.put(p1.val, rank.get(p1.val) + rank.get(p2.val));
        intervals.remove(p2);
      } else {
        parent.put(p1.val, p2);
        rank.put(p2.val, rank.get(p1.val) + rank.get(p2.val));
        intervals.remove(p1);
      }
      return true;
    }
}
  
