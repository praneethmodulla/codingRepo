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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] ans = new int[1];
        recurse(root, low, high, ans);
        return ans[0];
    }

    public void recurse(TreeNode root, int low, int high, int[] ans){
        if(root == null){
            return;
        }
        if(root.val >= low && root.val <= high){
            ans[0] += root.val;
        }
        if(root.val > high){
            recurse(root.left, low, high, ans);
        } else if(root.val < low){
            recurse(root.right, low, high, ans);
        } else {
            recurse(root.left, low, high, ans);
            recurse(root.right, low, high, ans);
        }
        return;
    }
}