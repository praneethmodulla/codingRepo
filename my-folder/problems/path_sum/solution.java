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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return recurse(root, targetSum, 0);
    }
    public boolean recurse(TreeNode node, int target, int sum){
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            sum += node.val;
            if(sum == target){
                return true;
            }
            return false;
        }
        sum += node.val;
        boolean checkLeft = recurse(node.left, target, sum);
        boolean checkRight = recurse(node.right, target, sum);
        sum -= node.val;
        return checkLeft || checkRight;
    }
}