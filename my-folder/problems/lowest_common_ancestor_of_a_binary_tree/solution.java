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

    public boolean recurse(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        boolean left = recurse(node.left, p, q);
        boolean right = recurse(node.right, p, q);
        if(node == p || node == q){
            if(right){
                left = true;
            } else if(left){
                right = true;
            } else {
                return true;
            }
        }
        if(left && right){
            result = node;
        }
        return left || right;
    }
}