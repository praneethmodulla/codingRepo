/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return result;
    }

    public void recurse(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return;
        }
        if(node.val >= p.val && node.val <= q.val){
            result = node;
            return;
        } else if(node.val >= q.val && node.val <= p.val){
            result = node;
            return;
        } else if(node.val > p.val && node.val > q.val){
            recurse(node.left, p, q);
        } else {
            recurse(node.right, p, q);
        }
        return;
    }
}