Q:-239 https://leetcode.com/problems/sliding-window-maximum/
========================================================C#=========================
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
