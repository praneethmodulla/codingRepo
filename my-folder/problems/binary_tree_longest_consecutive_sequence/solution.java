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
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] maxLen = new int[1];
        recurse(root, Integer.MIN_VALUE, maxLen, 0);
        return maxLen[0];
    }

    public void recurse(TreeNode root, int parent, int[] maxLen, int len){
        maxLen[0] = Math.max(maxLen[0], len);
        if(root == null){
            return;
        }
        if(parent == Integer.MIN_VALUE){
            recurse(root.left, root.val, maxLen, 1);
            recurse(root.right, root.val, maxLen, 1);
        } else {
            if(root.val == parent + 1){
                recurse(root.left, root.val, maxLen, len + 1);
                recurse(root.right, root.val, maxLen, len + 1);
            } else {
                recurse(root.left, root.val, maxLen, 1);
                recurse(root.right, root.val, maxLen, 1);
            }
        }
        return;
    }
}