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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        recurse(root, result, 0);
        return result;
    }
    public void recurse(TreeNode node, List<Integer> result, int level){
        if(node == null){
            return;
        }
        if(result.size() == level){
            result.add(node.val);
        }
        recurse(node.right, result, level + 1);
        recurse(node.left, result, level + 1);
        return;
    }
}