Q:- https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
***********************************************************************************************************
//Simple approach using heap
//T.C : O(nlogn)
//S.C : O(n)
--------------------------------------------------------------
  class Solution {
    class Pair {
    public char c;
    public int i;
    public Pair(char c, int i) {
        this.c = c;
        this.i = i;
    }
}

    public String clearStars(String s) {
        char[] str = s.toCharArray();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
        if(a.c == b.c)
        {
            return b.i - a.i;
        }
            return Character.compare(a.c, b.c);
        });

        for(int i = 0; i < str.length; i++)
        {
            char c = str[i];
            if(c != '*')
            {
                pq.add(new Pair(c,i));
                continue;
            }
            if(!pq.isEmpty())
            {
                Pair p = pq.poll();
                 str[p.i] = '*';
            }
        }
        char[] result = new char[str.length]; 
        int index = 0;
        for (char c : str) {
            if (c != '*') {
                result[index++] = c;
            }
        }
        return new String(result, 0, index); 
    }
}
