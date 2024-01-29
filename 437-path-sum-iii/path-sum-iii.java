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
      private Map<TreeNode, Map<Long, Integer>> cache = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int viaRoot = helper(root, targetSum, 0);
        int viaLeft = pathSum(root.left, targetSum);
        int viaRight = pathSum(root.right, targetSum);

        return viaRoot + viaLeft + viaRight;
    }

    private int helper(TreeNode root, int targetSum, long currentSum) {
        if (root == null) return 0;

        // Check if the result is already in the cache
//         if (cache.containsKey(root) && cache.get(root).containsKey(currentSum)) {
            
//             return cache.get(root).get(currentSum);
//         }

        int count = 0;
        currentSum += root.val;

        if (currentSum == targetSum) {
            count++;
        }

        count += helper(root.left, targetSum, currentSum);
        count += helper(root.right, targetSum, currentSum);

        // Store the result in the cache
        cache.putIfAbsent(root, new HashMap<>());
        cache.get(root).put(currentSum, count);

        return count;
    }

}