Q:- https://leetcode.com/problems/lfu-cache/
Company Tags                : Microsoft
*****************************************************************************************************
  class LFUCache {
    int capacity,minFrequency;
    Map<Integer,Node> map;
    Map<Integer,Set<Integer>> lruMap;

    class Node
    {
        int key,value,freq;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 1;
        map = new HashMap<>();
        lruMap = new HashMap<>();
    }
    
    public int get(int key) {
         if(!map.containsKey(key))
             return -1;

          Node node = map.get(key);
          update(node);
          return node.value;      
    }
    
    public void put(int key, int value) {
        if(capacity == 0)
              return;

         if(map.containsKey(key))
         {
            Node node = map.get(key);
            node.value = value;
            update(node);
         }
         else
         {
            if(map.size() == capacity)
            {
                int k = lruMap.get(minFrequency).iterator().next();
                map.remove(k);
                lruMap.get(minFrequency).remove(k);                
                if(lruMap.get(minFrequency).isEmpty()){
                    lruMap.remove(minFrequency);
                } 
            }
            Node node = new Node(key,value);
            map.put(key,node);
            
            minFrequency = 1;
            lruMap.putIfAbsent(minFrequency,new LinkedHashSet<>());
            lruMap.get(minFrequency).add(key); 
         }
    }

    void update(Node node)
    {
        int frequency = node.freq;
        lruMap.get(frequency).remove(node.key);

        if(lruMap.get(frequency).isEmpty())
        {
            lruMap.remove(frequency);
            if(frequency == minFrequency)
                 minFrequency++;
        }
        lruMap.putIfAbsent(frequency+1,new LinkedHashSet<>());
        lruMap.get(frequency+1).add(node.key);                  
        
        node.freq++;   
    }
}

