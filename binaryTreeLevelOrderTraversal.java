// Source : https://leetcode.com/problems/binary-tree-level-order-traversal/
// Author : Animesh Gupta
// Date   : 2015-10-07

/************************************************************************************************** 
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*************************************************************************************************************/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        //use of BFS
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        int curCount=1;
        int nextCount= 0;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();//queue.peek();
            //queue.remove();
            list.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
                nextCount++;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                nextCount++;
            }
            curCount--;
            if(curCount==0){
                curCount=nextCount;
                nextCount =0;
                output.add(list);
                list = new ArrayList<>();          
            }
           
        }
        return output;
    }
}
