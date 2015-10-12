// Source : https://leetcode.com/problems/palindrome-partitioning-ii/
// Author : Animesh Gupta
// Date   : 2015-10-11

/************************************************************************************************** 
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

**************************************************************************************************/ 

public class Solution {
    public int minCut(String s) {
        //we need to keep 2 arrays, one for min cut and 1 for partition table to chk for palindrome.
        if(s.length()==0)
            return 0;
        int []cut = new int[s.length()];
        int [][]partition = new int[s.length()][s.length()];
        for(int end=0;end<s.length();end++){
            cut[end] = end;
            for(int start=0;start<=end;start++){
                if(s.charAt(start)==s.charAt(end) &&((end-start<=1) || partition[start+1][end-1]==1)){
                         partition[start][end] = 1;
                         if(start>0){
                             //Most imp ,prev would be start-1, and we traversing for every row in the same col "end"
                             cut[end] = Math.min(cut[end],cut[start-1]+1);
                         }
                         else
                            cut[end] =0;
                }
            }
        }
        return cut[s.length()-1];
    }
}
