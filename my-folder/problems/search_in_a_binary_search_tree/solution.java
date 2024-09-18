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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode nodeResult = null;
        if(root == null){
            return nodeResult;
        }
        nodeResult = recurse(root, val, nodeResult);
        return nodeResult;
    }

    public TreeNode recurse(TreeNode node, int val, TreeNode nodeResult){
        if(node == null){
            return nodeResult;
        }
        if(node.val == val){
            nodeResult = node;
            return nodeResult;
        }
        if(node.val > val){
            nodeResult = recurse(node.left, val, nodeResult);
        } else {
            nodeResult = recurse(node.right, val, nodeResult);
        }
        return nodeResult;
    }
}