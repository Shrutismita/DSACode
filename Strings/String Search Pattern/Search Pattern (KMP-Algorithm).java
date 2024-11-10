Q:- https://www.geeksforgeeks.org/problems/search-pattern0205/1
// Given two strings, one is a text string, txt and the other is a pattern string, pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices. 
// Note: Return an empty list in case of no occurrences of pattern.
//   Examples :
// Input: txt = "abcab", pat = "ab"
// Output: [0, 3]
// Explanation: The string "ab" occurs twice in txt, one starts are index 1 and the other at index 4. 
**********************************************************************************************************************
//Using KMP-Algorithm
//Time Complexcity:- O(n + m)
----------------------------------------------------------------------
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// User function Template for Java

class Solution {

    ArrayList<Integer> search(String pat, String txt) {
           
           int n=txt.length();
           int m=pat.length();
           int[] LPS = new int[m];
           computeLPS(pat,LPS,m);
          
          ArrayList<Integer> result = new ArrayList<>();
          int i = 0, j = 0;
        
        
        while(i < n){
            
            if(txt.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            if(j == m)
            {
                result.add(i-j);
                j = LPS[j-1];
            }
            else if(txt.charAt(i) != pat.charAt(j))
            {
                if(j != 0)
                {
                    j =  LPS[j-1];
                }
                else
                {
                    i++;
                }
            }             
        }     
        return result;        
    }
    void computeLPS(String pat, int[] LPS, int m) {
        // code here
        LPS[0] = 0;
        int length = 0,i = 1;
       
        while(i < m)
        {
            if(pat.charAt(i) == pat.charAt(length)){
               length++;
               LPS[i] = length;
               i++;
            }else{
                if(length != 0)
                {
                    length = LPS[length - 1];
                }
                else
                {
                    LPS[i] = 0;
                    i++;
                }
            }
        }
        
    }

}
