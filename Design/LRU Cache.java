Q:- https://leetcode.com/problems/lru-cache/
 Company Tags                : Adobe, Microsoft, Amazon, Citygroup, Twitch ,Meta
**************************************************************************************************************
 //Using a HashMap and a Doubly-linked List 
//Time complexity: O(1) got get and put
//Space complexity: O(n) where n is the size of the cache
---------------------------------------------------------------------------
  class LRUCache {
    int capacity;
    Map<Integer,ListNode> cache;
    ListNode head;
    ListNode tail;

    class ListNode
    {
        int key,value;
        ListNode prev,next;
        ListNode(int key,int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        // dummy head and tail nodes to avoid null checks
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;   
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;

         ListNode node = cache.get(key);
          moveToHead(node);
         return node.value;   
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key))
        {
            ListNode node = cache.get(key);
               node.value = value;
               moveToHead(node);
        }
        else
        {
            ListNode newNode = new ListNode(key,value);
            cache.put(key,newNode);
            addNode(newNode);

            if(cache.size() > capacity)
            {
                ListNode tailNode = removeTail();
                cache.remove(tailNode.key);
            }
        }
    }

    void addNode(ListNode node)
    {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;

    }
    void removeNode(ListNode node)
    {
        ListNode prev = node.prev;
        ListNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    void moveToHead(ListNode node)
    {
        removeNode(node);
        addNode(node);
    }
    ListNode removeTail()
    {
        ListNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
