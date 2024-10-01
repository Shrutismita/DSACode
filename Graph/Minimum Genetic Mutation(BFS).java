Q:- https://leetcode.com/problems/minimum-genetic-mutation/

T.C:- O(n*m) where N is the length of the array M is the number of mutation elements.
S.C:- O(n)
============================================================================================
  class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
       
       // Adding all the strings in the bank
         Set<String> bankSet = new HashSet<>();
        for(String str : bank) bankSet.add(str);

        // Queue
        Queue<String> que = new LinkedList<>();
     
        // HashSet for marking visited
        Set<String> visited = new HashSet<>();
      
        que.add(startGene);
        visited.add(startGene);
        int count = 0;
        while(!que.isEmpty())
        {
            int n = que.size();
            for(int i = 0; i < n; i++)
            {
                String node = que.poll();
                if(node.equals(endGene))
                       return count;
                for(char ch :"ACGT".toCharArray())
                {
                    for(int j = 0;j <node.length();j++)
                    {
                        char arr[]= node.toCharArray();
                        arr[j] = ch;
                        String neighbour = new String(arr);
                        if(!visited.contains(neighbour) && bankSet.contains(neighbour))
                        {
                            que.add(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }       
            }
            count++;
        }
        return -1;
    }
}
