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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        recurse(root, val);
        return root;
    }

    public void recurse(TreeNode node, int val){
        if(node.val > val){
            if(node.left != null){
                recurse(node.left, val);
            } else {
                node.left = new TreeNode(val);
            }
        } else if(node.val < val){
            if(node.right != null){
                recurse(node.right, val);
            } else {
                node.right = new TreeNode(val);
            }
        }
        return;
    }
}