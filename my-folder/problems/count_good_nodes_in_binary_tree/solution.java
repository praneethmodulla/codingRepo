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
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        recurse(root, count, root.val);
        return count[0];
    }

    public void recurse(TreeNode node, int[] count, int maxSoFar){
        if(node == null){
            return;
        }
        if(node.val >= maxSoFar){
            count[0]++;
            maxSoFar = node.val;
        }
        recurse(node.left, count, Math.max(maxSoFar, node.val));
        recurse(node.right, count, Math.max(maxSoFar, node.val));
        return;
    }
}