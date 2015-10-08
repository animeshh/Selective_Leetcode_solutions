// Source : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
// Author : Animesh Gupta
// Date   : 2015-10-08

/************************************************************************************************** 

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

**************************************************************************************************/ 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    static Stack<TreeNode> st= new Stack<TreeNode>();
    
    public int kthSmallest(TreeNode root, int k) {
        TreeNode temp = root;
            
        while(temp!=null){
            st.push(temp);
            temp = temp.left;
        }
        TreeNode cur;
        while(k>=0){
            cur = st.pop();
            k--;
            if(k==0) 
                return cur.val;
            cur = cur.right;
            while(cur!=null){
                st.push(cur);
                cur = cur.left;
            }
        }
        return -1;
    }
}
