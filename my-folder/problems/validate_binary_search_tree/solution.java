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
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        return recurse(root.left, root.val, Long.MIN_VALUE) && recurse(root.right, Long.MAX_VALUE, root.val);
    }

    public boolean recurse(TreeNode node, long maxVal, long minVal){
        if(node == null){
            return true;
        }
        if(node.val > minVal && node.val < maxVal){
            return recurse(node.left, node.val, minVal) && recurse(node.right, maxVal, node.val);
        }
        return false;
    }
}