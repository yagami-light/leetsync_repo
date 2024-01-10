/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] count=new int[2];
        helper(root,k,count);
        return count[1];
        
        
    }
    
    private void helper(TreeNode root,int k,int[] count){
        if(root==null) return;
        helper(root.left,k,count);
        if(count[0]==k-1){
            count[1]=root.val;
            
        }
        count[0]++;
        // System.out.println("root value :"+root.val);
        helper(root.right,k,count);
        
        
        
    }
    
}