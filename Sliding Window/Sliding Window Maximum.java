Q:-239 https://leetcode.com/problems/sliding-window-maximum/
Company Tags : Media.Net (Directi, 2023 repeated), Google, Zenefits, Microsoft, Zoho, Flipkart, Amazon, Directi, SAP Labs
*********************************************************************************************************************************
****************************************** JAVA ******************************************************
//This is generally known as "Monotonic increasing/decreasing  Queue/Dequeue"
//Approach-1 (Using Deque) Every element is added(pushed) and popped only once,So it is O(n) time complexity.     
//T.C. :- O(n)
----------------------------------------------------------------------------------------------------------------------
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int i = 0, j = 0, ptr = 0;
        int[] result = new int[n-k+1];

        while(j < n)
        {
            while(!dq.isEmpty() && dq.peekLast()<nums[j])
            {
                dq.pollLast(); 
            }
             dq.add(nums[j]);
            if(j-i+1 < k)
            {
                j++; 
            }else if(j-i+1 == k)
            {
                result[ptr++] = dq.peek();
                if(nums[i] == dq.peek())
                {
                    dq.pollFirst(); 
                }
                i++; 
                j++;
            }
        }
        return result;
    }
}                          
========================================================C#==========================================================================
  public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.Length;
         LinkedList<int> deque = new LinkedList<int>();
        int[] result = new int[n-k+1];
        while(j < n)
        {
            while(deque.Count > 0 && nums[deque.Last.Value] < nums[j])
            {
                deque.RemoveLast();
            }
            deque.AddLast(j);
            if(deque.Count > 0 && i > deque.First.Value)
            {
                deque.RemoveLast();
            }
            if(j >= k - 1)
            {
                  result[i++] = nums[deque.First.Value];
            }
            j++;
        }
        return result;
    }
}
