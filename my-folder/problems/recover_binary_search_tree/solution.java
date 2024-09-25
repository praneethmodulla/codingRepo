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
    private TreeNode first;
    private TreeNode last;
    private TreeNode middle;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        recurse(root);
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        return;
    }

    public void recurse(TreeNode node){
        if(node == null){
            return;
        }
        recurse(node.left);
        if(prev != null && node.val < prev.val){
            if(first == null){
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }
        prev = node;
        recurse(node.right);
        return;
    }
}