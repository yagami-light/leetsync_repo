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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        
        long viaRoot=helper(root,targetSum);
        
        int viaLeft=pathSum(root.left,targetSum);
        int viaRight=pathSum(root.right,targetSum);
        
        
        return (int)(viaRoot+viaLeft+viaRight);
    }
    
    private long helper(TreeNode root, long targetSum){
        if(root==null) return 0;
         long count=0;
        if(root.val == targetSum){
             count++;
        }
        
       
        
        count +=helper(root.left,targetSum-root.val);
        count +=helper(root.right,targetSum-root.val);
        
        return count;
    }
}