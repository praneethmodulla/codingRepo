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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = recurse(root.left);
        TreeNode right = recurse(root.right);
        if(left != null){
            root.right = left;
        }
        while(left != null && left.right != null){
            left = left.right;
        }
        if(left != null){
            left.right = right;
        }
        root.left = null;
        return;
    }
    public TreeNode recurse(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode left = recurse(root.left);
        TreeNode right = recurse(root.right);
        if(left != null){
            root.right = left;
        }
        while(left != null && left.right != null){
            left = left.right;
        }
        if(left != null){
            left.right = right;
        }
        root.left = null;
        return root;
    }
}