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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        recurse(root, sb, result);
        return result;
    }

    public void recurse(TreeNode root, StringBuilder sb, List<String> res){
        if(root == null){
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        String s = sb.toString();
        recurse(root.left, sb, res);
        recurse(root.right, new StringBuilder(s), res);
        return;
    }
}