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
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] count = new int[1];
        recurse(root, count, root.val);
        return count[0];
    }

    public boolean recurse(TreeNode node, int[] count, int val){
        if(node == null){
           return true; 
        }
        boolean left = recurse(node.left, count, node.val);
        boolean right = recurse(node.right, count, node.val);
        if(left && right){
            count[0]++;
        }
        return (node.val == val) && (left && right);
    }
}