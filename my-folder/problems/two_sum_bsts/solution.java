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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null){
            return false;
        }
        if(dfs(root2, target - root1.val)){
            return true;
        }
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    public boolean dfs(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(target == root.val){
            return true;
        }
        if(target > root.val){
            return dfs(root.right, target);
        }
        return dfs(root.left, target);
    }
}