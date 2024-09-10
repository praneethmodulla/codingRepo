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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        result = recurse(root, result);
        return result;
    }

    public List<Integer> recurse(TreeNode root, List<Integer> result){
        if(root == null){
            return result;
        } 

        result = recurse(root.left, result);
        result = recurse(root.right, result);
        result.add(root.val);
        return result;
    }
}