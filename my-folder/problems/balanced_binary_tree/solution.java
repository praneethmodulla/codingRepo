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
    public boolean isBalanced(TreeNode root) {
        boolean[] isBalance = new boolean[1];
        isBalance[0] = true;
        int val = recurse(root, isBalance);
        return isBalance[0];
        
    }
    public int recurse(TreeNode root, boolean[] isBalance){
        if(root == null){
            return 0;
        }
        if(!isBalance[0]){
            return 0;
        }
        int leftHeight = recurse(root.left, isBalance);
        int rightHeight = recurse(root.right, isBalance);
        if(Math.abs(leftHeight - rightHeight) > 1){
            isBalance[0] = false;
        }
        return Math.max(leftHeight, rightHeight) + 1; 
    }
}