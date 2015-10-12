// Source : https://leetcode.com/problems/palindrome-partitioning/
// Author : Animesh Gupta
// Date   : 2015-10-12

/************************************************************************************************** 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
**************************************************************************************************/ 

  public class Solution {
    List<List<String>> res;
    
    void chkPal(int[][]dp,List<String> list,String str,int start){
        if(start==str.length()){
            res.add(list);
            return;
        }
        for(int c=start;c<str.length();c++){
            if(str.charAt(start)==str.charAt(c) && (c-start<= 1|| dp[start+1][c-1]==1)){
                dp[start][c] = 1;
                List<String> newlist = new ArrayList<>(list);
                newlist.add(str.substring(start,c+1));
                chkPal(dp,newlist,str,c+1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int len = s.length();
        res = new ArrayList<List<String>>();
        if(len==0)
            return res;
        List<String> list = new ArrayList<String>();
        int [][] table = new int[len][len];
        chkPal(table,list,s,0);
        return res;
    }

}
