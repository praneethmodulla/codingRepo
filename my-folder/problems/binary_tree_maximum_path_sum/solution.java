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
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        recurse(root, maxSum);
        return maxSum[0];
    }

    public int recurse(TreeNode root, int[] maxSum){
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0, recurse(root.left, maxSum));
        int rightSum = Math.max(0, recurse(root.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}